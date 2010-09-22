package jp.mitukiii.tumblife2.model;

import jp.mitukiii.tumblife2.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class TLSetting extends TLModel
{
  public static enum PIN_ACTION_TYPE {
    None,
    Back,
    Next
  };
  
  public static enum VIEW_MODE_TYPE {
    Default (null),
    Quote ("quote"),
    Photos ("photo");
    
    private String type;
    
    private VIEW_MODE_TYPE(String type)
    {
      this.type = type;
    }
    
    public String getType()
    {
      return type;
    }
  };
  
  protected static TLSetting settingManager;

  protected String                  email;
  protected String                  password;

  protected boolean                 useSsl;
  protected boolean                 useQuickpost;
  protected boolean                 usePin;
  protected PIN_ACTION_TYPE         pinAction;
  protected VIEW_MODE_TYPE          viewMode;
  protected boolean                 useSkipMinePost;
  protected boolean                 useSkipPhotos;
  protected boolean                 useSavePhotos;
  protected boolean                 useClearCache;
  
  protected TLSetting(Context context)
  {
    loadAccount(context);
    loadSetting(context);
  }
  
  public static TLSetting getSharedInstance(Context context)
  {
    if (settingManager == null) {
      settingManager = new TLSetting(context);
    }
    return settingManager;
  }
  
  public void loadAccount(Context context)
  {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
    
    email = preferences.getString(
        context.getString(R.string.setting_email_key),
        "");
    
    password = preferences.getString(
        context.getString(R.string.setting_password_key),
        "");
    
    String viewModeString = preferences.getString(
        context.getString(R.string.setting_viewmode_key),
        context.getString(R.string.setting_viewmode_default));
    viewMode = VIEW_MODE_TYPE.valueOf(viewModeString);
  }
  
  public void loadSetting(Context context)
  {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
    
    useSsl = preferences.getBoolean(
        context.getString(R.string.setting_usessl_key),
        Boolean.valueOf(context.getString(R.string.setting_usessl_default)));
    
    useQuickpost = preferences.getBoolean(
        context.getString(R.string.setting_quickpost_key),
        Boolean.valueOf(context.getString(R.string.setting_quickpost_default)));
    
    usePin = preferences.getBoolean(
        context.getString(R.string.setting_usepin_key),
        Boolean.valueOf(context.getString(R.string.setting_usepin_default)));
    
    useSkipMinePost = preferences.getBoolean(
        context.getString(R.string.setting_skipminepost_key),
        Boolean.valueOf(context.getString(R.string.setting_skipminepost_default)));
    
    useSkipPhotos = preferences.getBoolean(
        context.getString(R.string.setting_skipphotos_key),
        Boolean.valueOf(context.getString(R.string.setting_skipphotos_default)));
    
    useSavePhotos = preferences.getBoolean(
        context.getString(R.string.setting_savephotos_key),
        Boolean.valueOf(context.getString(R.string.setting_savephotos_default)));
    
    useClearCache = preferences.getBoolean(
        context.getString(R.string.setting_clearcache_key),
        Boolean.valueOf(context.getString(R.string.setting_clearcache_default)));
    
    String pinActionString = preferences.getString(
        context.getString(R.string.setting_pinaction_key),
        context.getString(R.string.setting_pinaction_default));
    pinAction = PIN_ACTION_TYPE.valueOf(pinActionString);
  }

  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
  }

  public boolean useSsl()
  {
    return useSsl;
  }

  public boolean useQuickpost()
  {
    return useQuickpost;
  }

  public boolean usePin()
  {
    return usePin;
  }

  public PIN_ACTION_TYPE getPinAction()
  {
    return pinAction;
  }

  public VIEW_MODE_TYPE getViewMode()
  {
    return viewMode;
  }

  public boolean useSkipMinePost()
  {
    return useSkipMinePost;
  }

  public boolean useSkipPhotos()
  {
    return useSkipPhotos;
  }

  public boolean useSavePhotos()
  {
    return useSavePhotos;
  }

  public boolean useClearCache()
  {
    return useClearCache;
  }
}
