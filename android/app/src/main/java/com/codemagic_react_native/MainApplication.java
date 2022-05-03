package com.codemagic_react_native;

import android.app.Application;
import android.content.Context;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {
//   DesiredCapabilities capabilities = new DesiredCapabilities();
//   capabilities.setCapability("pCloudy_Username", "nihal@nevercode.io");
//   capabilities.setCapability("pCloudy_ApiKey", "93zqy94twt7325vhkg49cbkf");
//   capabilities.setCapability("pCloudy_DurationInMinutes", 20);
//   capabilities.setCapability("newCommandTimeout", 600);
//   capabilities.setCapability("launchTimeout", 90000);
//   capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_Pixel2_Android_11.0.0_c2579");
//   capabilities.setCapability("platformVersion", "11.0.0");
//   capabilities.setCapability("platformName", "Android");
//   capabilities.setCapability("automationName", "uiautomator2");
//   capabilities.setCapability("appPackage", "testing");
//   capabilities.setCapability("appActivity", "gaming");
//   capabilities.setCapability("pCloudy_WildNet", "false");
//   capabilities.setCapability("pCloudy_EnableVideo", "false");
//   capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
//   capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
//   AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);

  private final ReactNativeHost mReactNativeHost =
      new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
          return packages;
        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
  }

  /**
   * Loads Flipper in React Native templates. Call this in the onCreate method with something like
   * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
   *
   * @param context
   * @param reactInstanceManager
   */
  private static void initializeFlipper(
      Context context, ReactInstanceManager reactInstanceManager) {
    if (BuildConfig.DEBUG) {
      try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
        Class<?> aClass = Class.forName("com.codemagic_react_native.ReactNativeFlipper");
        aClass
            .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
            .invoke(null, context, reactInstanceManager);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }
}
