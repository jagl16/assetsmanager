package jg.robolibs.assetsmanager;

import java.io.IOException;
import java.io.InputStream;

public interface IAssetsManager {
    /**
     * Open an asset. This provides access to files that have been bundled with an application as assets -- that is, files placed in to the "assets" directory.
     *
     * @param path relative path to the assets directory
     * @throws IOException
     */
    InputStream open(String path) throws IOException;

    /**
     * Close this asset manager.
     */
    void close();

    /**
     * Return a String array of all the assets at the given path.
     *
     * @param path path to look up
     * @return Return a String array of all the assets at the given path.
     */
    String[] list(String path) throws IOException;
}
