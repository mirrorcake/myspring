package com.mirrorcake.myspring.ioc.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 *  resolve resources in some path
 *
 * @author mirrorcake
 */
public class ResourceResolver {
    private final Logger logger = LoggerFactory.getLogger(ResourceResolver.class);

    String basePackage;

    public ResourceResolver(String basePackage) {
        this.basePackage = basePackage;
    }

    public List<Resource> scan() {
        String basePackagePath = this.basePackage.replace(".", "/");
        List<Resource> resourceCollector = new ArrayList<>();
        try {
            doScan(basePackagePath, basePackagePath, resourceCollector);
        } catch (IOException e) {
            logger.error("error@ResourceResolver.scan, IOException", e);
        } catch (URISyntaxException e) {
            logger.error("error@ResourceResolver.scan, URISyntaxException", e);
        }
        return resourceCollector;
    }

    void doScan(String basePackagePath, String path, List<Resource> resourceCollector)
            throws IOException, URISyntaxException {
        Enumeration<URL> enumeration = getContextClassLoader().getResources(path);
        while (enumeration.hasMoreElements()) {
            URI uri = enumeration.nextElement().toURI();
            String uriStr = uri.toString();
            String uriBaseStr = uriStr.substring(0, uriStr.length() - basePackagePath.length());
            if (uriBaseStr.startsWith("file:")) {
                uriBaseStr = uriBaseStr.substring(5);
            }
            if (uriStr.startsWith("jar:")) {
                scanFile(true, uriBaseStr, jarUri2Path(basePackagePath, uri), resourceCollector);
            } else {
                scanFile(false, uriBaseStr, Paths.get(uri), resourceCollector);
            }
        }
    }

    void scanFile(boolean isJar, String base, Path root, List<Resource> resourceCollector) throws IOException {
        String baseDir = removeEndSlash(base);
        Files.walk(root).filter(Files::isRegularFile).forEach(file -> {
            Resource resource = null;
            if (isJar) {
                resource = new Resource(baseDir, removeStartSlash(file.toString()));
            } else {
                String path = file.toString();
                String name = removeStartSlash(path.substring(baseDir.length()));
                resource = new Resource("file:" + path, name);
            }
            logger.debug("debug@ResourceResolver.scanFile, found resource: {}", resource);
            resourceCollector.add(resource);
        });
    }

    Path jarUri2Path(String basePackagePath, URI uri) throws IOException {
        return FileSystems.newFileSystem(uri, new HashMap<>()).getPath(basePackagePath);
    }


    /**
     * get class loader
     * */
    ClassLoader getContextClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = getClass().getClassLoader();
        }
        return classLoader;
    }

    String removeStartSlash(String s){
        return s.startsWith("/") || s.startsWith("\\") ? s.substring(1) : s;
    }

    String removeEndSlash(String s){
        return s.endsWith("/") || s.endsWith("\\") ? s.substring(0, s.length()-1) : s;
    }

}
