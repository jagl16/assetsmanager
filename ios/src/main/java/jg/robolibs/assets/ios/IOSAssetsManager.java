package jg.robolibs.assets.ios;

import jg.robolibs.assetsmanager.IAssetsManager;
import org.robovm.apple.foundation.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jgarcia on 12/4/15.
 * iOS assets manager implementation.
 */
public class IOSAssetsManager implements IAssetsManager {
    /**
     * Open an asset. This provides access to files that have been bundled with an application as assets -- that is, files placed in to the "application bundle"
     *
     * @param path relative path to the assets directory
     * @throws IOException
     */
    @Override
    public InputStream open(String path) throws IOException {
        //TODO: Since this is called from core, we need to flatten the path to comply with how iOS packs the bundle resources.
        NSData data = NSData.read(new File(path));
        return new ByteArrayInputStream(data.getBytes());
    }

    /**
     * Close this asset manager.
     */
    @Override
    public void close() {
        //ignore in iOS?
    }

    /**
     * Return a String array of all the assets at the given path.
     *
     * @param path path to look up
     * @return Return a String array of all the assets at the given path.
     */
    @Override
    public String[] list(String path) throws IOException {
        String[] list;
        try {
            String p = NSBundle.getMainBundle().getResourcePath() + path;
            NSArray array = NSFileManager.getDefaultManager().getContentsOfDirectoryAtPath(p);
            list = new String[array.size()];
            for (int i = 0; i < array.size(); i++)
                list[i] = array.get(i).toString();
        } catch (NSErrorException e) {
            throw new IOException(e);
        }
        return list;
    }
}
