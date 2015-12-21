package jg.robolibs.assets;

import android.content.Context;
import android.content.res.AssetManager;
import jg.robolibs.assetsmanager.IAssetsManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jgarcia on 12/4/15.j
 */
public class DroidAssetsManager implements IAssetsManager {

    AssetManager assetManager;
    public DroidAssetsManager(Context ctx){
        assetManager = ctx.getAssets();
    }

    @Override
    public InputStream open(String path) throws IOException {
        return assetManager.open(path);
    }

    @Override
    public void close() {
        assetManager.close();
    }

    @Override
    public String[] list(String path) throws IOException {
        if(path != null && (path.equalsIgnoreCase(".") || path.equalsIgnoreCase("~")))
            path = "";
        return assetManager.list(path);
    }
}
