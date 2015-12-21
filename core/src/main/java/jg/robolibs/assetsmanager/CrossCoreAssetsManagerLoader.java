/*
 * Copyright (C) 2015 Jesus Garcia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jg.robolibs.assetsmanager;

/**
 * Class that manages the AssetsManager object, this allows us to initialize per platform the assets manager.
 */
public class CrossCoreAssetsManagerLoader {
    private IAssetsManager assetsManager;
    private static CrossCoreAssetsManagerLoader instance;

    private CrossCoreAssetsManagerLoader(IAssetsManager mgr) {
        assetsManager = mgr;
    }

    /**
     * Initializes the CrossCoreAssetsManager class with an platform assets manager.
     * This should always be called before trying to get the shared instance.
     *
     * @param assetsManager Platform assets manager
     * @return The initialized instance of the CrossCoreAssetsManagerLoader
     */
    public static CrossCoreAssetsManagerLoader init(IAssetsManager assetsManager) {
        instance = new CrossCoreAssetsManagerLoader(assetsManager);
        return instance;
    }

    /**
     * Returns the instance of the CrossCoreAssetsManagerLoader, before calling this method
     * you should have called init once.
     *
     * @return The shared instance of the IAssetsManager
     * @throws Exception An exception for not initializing the class first.
     */
    public static CrossCoreAssetsManagerLoader getInstance() throws Exception {
        if (instance == null)
            throw new Exception("CrossCoreAssetsManagerLoader not initialized.");
        return instance;
    }

    public IAssetsManager getAssetsManager() {
        return assetsManager;
    }
}
