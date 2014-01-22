package com.adsdk.sdk;

public interface Const {

	public static final String TAG = "ADSDK";
	public static final String ENCODING = "UTF-8";
	public static final String RESPONSE_ENCODING = "ISO-8859-1";
	public static final String VERSION = "5.0.0";
	public static final String PROTOCOL_VERSION = "1.0";

	public static final int LIVE = 0;
	public static final int TEST = 1;

	public static final String IMAGE_BODY = "<body style='\"'margin: 0px; padding: 0px; text-align:center;'\"'><img src='\"'{0}'\"' width='\"'{1}'dp\"' height='\"'{2}'dp\"'/></body>";
	//	public static final String IMAGE_BODY = "<body style='\"'margin: 0px; padding: 0px; text-align:center;'\"'><div style=\"background-image:{0} width='\"'{1}'dp\"' height='\"'{2}'dp\"'></div></body>";
	public static final String REDIRECT_URI = "REDIRECT_URI";

	public static final String HIDE_BORDER = "<style>* { -webkit-tap-highlight-color: rgba(0,0,0,0);} img {width:100%;height:100%}</style>";
	//	public static final String HIDE_BORDER = "<style>* { -webkit-tap-highlight-color: rgba(0,0,0,0) }</style>";

	public static final int TOUCH_DISTANCE = 30;

	public static final long VIDEO_LOAD_TIMEOUT = 1200000;
	public static final int CONNECTION_TIMEOUT = 10000; // = 15 sec
	public static final int SOCKET_TIMEOUT = 10000; // = 15 sec

	public static final String PREFS_DEVICE_ID = "device_id";

	public static final String USER_AGENT_PATTERN = "Mozilla/5.0 (Linux; U; Android %1$s; %2$s; %3$s Build/%4$s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
	public static final String AD_EXTRA = "RICH_AD_DATA";
	public static final String AD_TYPE_EXTRA = "RICH_AD_TYPE";
	public static final int MAX_NUMBER_OF_TRACKING_RETRIES = 5;

	public static final String CONNECTION_TYPE_UNKNOWN = "UNKNOWN";
	public static final String CONNECTION_TYPE_WIFI = "WIFI";
	public static final String CONNECTION_TYPE_WIMAX = "WIMAX";
	public static final String CONNECTION_TYPE_MOBILE_UNKNOWN = "MOBILE";
	public static final String CONNECTION_TYPE_MOBILE_1xRTT = "1xRTT";
	public static final String CONNECTION_TYPE_MOBILE_CDMA = "CDMA";
	public static final String CONNECTION_TYPE_MOBILE_EDGE = "EDGE";
	public static final String CONNECTION_TYPE_MOBILE_EHRPD = "EHRPD";
	public static final String CONNECTION_TYPE_MOBILE_EVDO_0 = "EVDO_0";
	public static final String CONNECTION_TYPE_MOBILE_EVDO_A = "EVDO_A";
	public static final String CONNECTION_TYPE_MOBILE_EVDO_B = "EVDO_B";
	public static final String CONNECTION_TYPE_MOBILE_GPRS = "GPRS";
	public static final String CONNECTION_TYPE_MOBILE_HSDPA = "HSDPA";
	public static final String CONNECTION_TYPE_MOBILE_HSPA = "HSPA";
	public static final String CONNECTION_TYPE_MOBILE_HSPAP = "HSPAP";
	public static final String CONNECTION_TYPE_MOBILE_HSUPA = "HSUPA";
	public static final String CONNECTION_TYPE_MOBILE_IDEN = "IDEN";
	public static final String CONNECTION_TYPE_MOBILE_LTE = "LTE";
	public static final String CONNECTION_TYPE_MOBILE_UMTS = "UMTS";

	public static final CharSequence LOADING = "Loading....";
	public static final long CACHE_DOWNLOAD_PERIOD = 10 * 60 * 1000;

	public final static int AD_FAILED = -1;
	public final static int IMAGE = 0;
	public final static int TEXT = 1;
	public final static int NO_AD = 2;
	public final static int VIDEO_TO_INTERSTITIAL = 3;
	public final static int INTERSTITIAL_TO_VIDEO = 4;
	public final static int VIDEO = 5;
	public final static int INTERSTITIAL = 6;
	public final static int MRAID = 7;
	
	public static final String mraid = "(function() {\r\n" + 
			"  var isIOS = (/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());\r\n" + 
			"  if (isIOS) {\r\n" + 
			"    console = {};\r\n" + 
			"    console.log = function(log) {\r\n" + 
			"      var iframe = document.createElement('iframe');\r\n" + 
			"      iframe.setAttribute('src', 'ios-log: ' + log);\r\n" + 
			"      document.documentElement.appendChild(iframe);\r\n" + 
			"      iframe.parentNode.removeChild(iframe);\r\n" + 
			"      iframe = null;\r\n" + 
			"    };\r\n" + 
			"    console.debug = console.info = console.warn = console.error = console.log;\r\n" + 
			"  }\r\n" + 
			"}());\r\n" + 
			"\r\n" + 
			"(function() {\r\n" + 
			"  // Establish the root mraidbridge object.\r\n" + 
			"  var mraidbridge = window.mraidbridge = {};\r\n" + 
			"\r\n" + 
			"  // Listeners for bridge events.\r\n" + 
			"  var listeners = {};\r\n" + 
			"\r\n" + 
			"  // Queue to track pending calls to the native SDK.\r\n" + 
			"  var nativeCallQueue = [];\r\n" + 
			"\r\n" + 
			"  // Whether a native call is currently in progress.\r\n" + 
			"  var nativeCallInFlight = false;\r\n" + 
			"\r\n" + 
			"  //////////////////////////////////////////////////////////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  mraidbridge.fireReadyEvent = function() {\r\n" + 
			"    mraidbridge.fireEvent('ready');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraidbridge.fireChangeEvent = function(properties) {\r\n" + 
			"    mraidbridge.fireEvent('change', properties);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraidbridge.fireErrorEvent = function(message, action) {\r\n" + 
			"    mraidbridge.fireEvent('error', message, action);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraidbridge.fireEvent = function(type) {\r\n" + 
			"    var ls = listeners[type];\r\n" + 
			"    if (ls) {\r\n" + 
			"      var args = Array.prototype.slice.call(arguments);\r\n" + 
			"      args.shift();\r\n" + 
			"      var l = ls.length;\r\n" + 
			"      for (var i = 0; i < l; i++) {\r\n" + 
			"        ls[i].apply(null, args);\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraidbridge.nativeCallComplete = function(command) {\r\n" + 
			"    if (nativeCallQueue.length === 0) {\r\n" + 
			"      nativeCallInFlight = false;\r\n" + 
			"      return;\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    var nextCall = nativeCallQueue.pop();\r\n" + 
			"    window.location = nextCall;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraidbridge.executeNativeCall = function(command) {\r\n" + 
			"    var call = 'mraid://' + command;\r\n" + 
			"\r\n" + 
			"    var key, value;\r\n" + 
			"    var isFirstArgument = true;\r\n" + 
			"\r\n" + 
			"    for (var i = 1; i < arguments.length; i += 2) {\r\n" + 
			"      key = arguments[i];\r\n" + 
			"      value = arguments[i + 1];\r\n" + 
			"\r\n" + 
			"      if (value === null) continue;\r\n" + 
			"\r\n" + 
			"      if (isFirstArgument) {\r\n" + 
			"        call += '?';\r\n" + 
			"        isFirstArgument = false;\r\n" + 
			"      } else {\r\n" + 
			"        call += '&';\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      call += encodeURIComponent(key) + '=' + encodeURIComponent(value);\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    if (nativeCallInFlight) {\r\n" + 
			"      nativeCallQueue.push(call);\r\n" + 
			"    } else {\r\n" + 
			"      nativeCallInFlight = true;\r\n" + 
			"      window.location = call;\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  //////////////////////////////////////////////////////////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  mraidbridge.addEventListener = function(event, listener) {\r\n" + 
			"    var eventListeners;\r\n" + 
			"    listeners[event] = listeners[event] || [];\r\n" + 
			"    eventListeners = listeners[event];\r\n" + 
			"\r\n" + 
			"    for (var l in eventListeners) {\r\n" + 
			"      // Listener already registered, so no need to add it.\r\n" + 
			"      if (listener === l) return;\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    eventListeners.push(listener);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraidbridge.removeEventListener = function(event, listener) {\r\n" + 
			"    if (listeners.hasOwnProperty(event)) {\r\n" + 
			"      var eventListeners = listeners[event];\r\n" + 
			"      if (eventListeners) {\r\n" + 
			"        var idx = eventListeners.indexOf(listener);\r\n" + 
			"        if (idx !== -1) {\r\n" + 
			"          eventListeners.splice(idx, 1);\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"}());\r\n" + 
			"\r\n" + 
			"(function() {\r\n" + 
			"  var mraid = window.mraid = {};\r\n" + 
			"  var bridge = window.mraidbridge;\r\n" + 
			"\r\n" + 
			"  // Constants. ////////////////////////////////////////////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  var VERSION = mraid.VERSION = '2.0';\r\n" + 
			"\r\n" + 
			"  var STATES = mraid.STATES = {\r\n" + 
			"    LOADING: 'loading',     // Initial state.\r\n" + 
			"    DEFAULT: 'default',\r\n" + 
			"    EXPANDED: 'expanded',\r\n" + 
			"    HIDDEN: 'hidden'\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var EVENTS = mraid.EVENTS = {\r\n" + 
			"    ERROR: 'error',\r\n" + 
			"    INFO: 'info',\r\n" + 
			"    READY: 'ready',\r\n" + 
			"    STATECHANGE: 'stateChange',\r\n" + 
			"    VIEWABLECHANGE: 'viewableChange'\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var PLACEMENT_TYPES = mraid.PLACEMENT_TYPES = {\r\n" + 
			"    UNKNOWN: 'unknown',\r\n" + 
			"    INLINE: 'inline',\r\n" + 
			"    INTERSTITIAL: 'interstitial'\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  // External MRAID state: may be directly or indirectly modified by the ad JS. ////////////////////\r\n" + 
			"\r\n" + 
			"  // Properties which define the behavior of an expandable ad.\r\n" + 
			"  var expandProperties = {\r\n" + 
			"    width: -1,\r\n" + 
			"    height: -1,\r\n" + 
			"    useCustomClose: false,\r\n" + 
			"    isModal: true,\r\n" + 
			"    lockOrientation: false\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var hasSetCustomSize = false;\r\n" + 
			"\r\n" + 
			"  var hasSetCustomClose = false;\r\n" + 
			"\r\n" + 
			"  var listeners = {};\r\n" + 
			"\r\n" + 
			"  // Internal MRAID state. Modified by the native SDK. /////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  var state = STATES.LOADING;\r\n" + 
			"\r\n" + 
			"  var isViewable = false;\r\n" + 
			"\r\n" + 
			"  var screenSize = { width: -1, height: -1 };\r\n" + 
			"\r\n" + 
			"  var placementType = PLACEMENT_TYPES.UNKNOWN;\r\n" + 
			"\r\n" + 
			"  var supports = {\r\n" + 
			"    sms: false,\r\n" + 
			"    tel: false,\r\n" + 
			"    calendar: false,\r\n" + 
			"    storePicture: false,\r\n" + 
			"    inlineVideo: false\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  //////////////////////////////////////////////////////////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  var EventListeners = function(event) {\r\n" + 
			"    this.event = event;\r\n" + 
			"    this.count = 0;\r\n" + 
			"    var listeners = {};\r\n" + 
			"\r\n" + 
			"    this.add = function(func) {\r\n" + 
			"      var id = String(func);\r\n" + 
			"      if (!listeners[id]) {\r\n" + 
			"        listeners[id] = func;\r\n" + 
			"        this.count++;\r\n" + 
			"      }\r\n" + 
			"    };\r\n" + 
			"\r\n" + 
			"    this.remove = function(func) {\r\n" + 
			"      var id = String(func);\r\n" + 
			"      if (listeners[id]) {\r\n" + 
			"        listeners[id] = null;\r\n" + 
			"        delete listeners[id];\r\n" + 
			"        this.count--;\r\n" + 
			"        return true;\r\n" + 
			"      } else {\r\n" + 
			"        return false;\r\n" + 
			"      }\r\n" + 
			"    };\r\n" + 
			"\r\n" + 
			"    this.removeAll = function() {\r\n" + 
			"      for (var id in listeners) {\r\n" + 
			"        if (listeners.hasOwnProperty(id)) this.remove(listeners[id]);\r\n" + 
			"      }\r\n" + 
			"    };\r\n" + 
			"\r\n" + 
			"    this.broadcast = function(args) {\r\n" + 
			"      for (var id in listeners) {\r\n" + 
			"        if (listeners.hasOwnProperty(id)) listeners[id].apply({}, args);\r\n" + 
			"      }\r\n" + 
			"    };\r\n" + 
			"\r\n" + 
			"    this.toString = function() {\r\n" + 
			"      var out = [event, ':'];\r\n" + 
			"      for (var id in listeners) {\r\n" + 
			"        if (listeners.hasOwnProperty(id)) out.push('|', id, '|');\r\n" + 
			"      }\r\n" + 
			"      return out.join('');\r\n" + 
			"    };\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var broadcastEvent = function() {\r\n" + 
			"    var args = new Array(arguments.length);\r\n" + 
			"    var l = arguments.length;\r\n" + 
			"    for (var i = 0; i < l; i++) args[i] = arguments[i];\r\n" + 
			"    var event = args.shift();\r\n" + 
			"    if (listeners[event]) listeners[event].broadcast(args);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var contains = function(value, array) {\r\n" + 
			"    for (var i in array) {\r\n" + 
			"      if (array[i] === value) return true;\r\n" + 
			"    }\r\n" + 
			"    return false;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var clone = function(obj) {\r\n" + 
			"    if (obj === null) return null;\r\n" + 
			"    var f = function() {};\r\n" + 
			"    f.prototype = obj;\r\n" + 
			"    return new f();\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var stringify = function(obj) {\r\n" + 
			"    if (typeof obj === 'object') {\r\n" + 
			"      var out = [];\r\n" + 
			"      if (obj.push) {\r\n" + 
			"        // Array.\r\n" + 
			"        for (var p in obj) out.push(obj[p]);\r\n" + 
			"        return '[' + out.join(',') + ']';\r\n" + 
			"      } else {\r\n" + 
			"        // Other object.\r\n" + 
			"        for (var p in obj) out.push(\"'\" + p + \"': \" + obj[p]);\r\n" + 
			"        return '{' + out.join(',') + '}';\r\n" + 
			"      }\r\n" + 
			"    } else return String(obj);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var trim = function(str) {\r\n" + 
			"    return str.replace(/^\\s+|\\s+$/g, '');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  // Functions that will be invoked by the native SDK whenever a \"change\" event occurs.\r\n" + 
			"  var changeHandlers = {\r\n" + 
			"    state: function(val) {\r\n" + 
			"      if (state === STATES.LOADING) {\r\n" + 
			"        broadcastEvent(EVENTS.INFO, 'Native SDK initialized.');\r\n" + 
			"      }\r\n" + 
			"      state = val;\r\n" + 
			"      broadcastEvent(EVENTS.INFO, 'Set state to ' + stringify(val));\r\n" + 
			"      broadcastEvent(EVENTS.STATECHANGE, state);\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    viewable: function(val) {\r\n" + 
			"      isViewable = val;\r\n" + 
			"      broadcastEvent(EVENTS.INFO, 'Set isViewable to ' + stringify(val));\r\n" + 
			"      broadcastEvent(EVENTS.VIEWABLECHANGE, isViewable);\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    placementType: function(val) {\r\n" + 
			"      broadcastEvent(EVENTS.INFO, 'Set placementType to ' + stringify(val));\r\n" + 
			"      placementType = val;\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    screenSize: function(val) {\r\n" + 
			"      broadcastEvent(EVENTS.INFO, 'Set screenSize to ' + stringify(val));\r\n" + 
			"      for (var key in val) {\r\n" + 
			"        if (val.hasOwnProperty(key)) screenSize[key] = val[key];\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      if (!hasSetCustomSize) {\r\n" + 
			"        expandProperties['width'] = screenSize['width'];\r\n" + 
			"        expandProperties['height'] = screenSize['height'];\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    expandProperties: function(val) {\r\n" + 
			"      broadcastEvent(EVENTS.INFO, 'Merging expandProperties with ' + stringify(val));\r\n" + 
			"      for (var key in val) {\r\n" + 
			"        if (val.hasOwnProperty(key)) expandProperties[key] = val[key];\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    supports: function(val) {\r\n" + 
			"      broadcastEvent(EVENTS.INFO, 'Set supports to ' + stringify(val));\r\n" + 
			"        supports = val;\r\n" + 
			"    },\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var validate = function(obj, validators, action, merge) {\r\n" + 
			"    if (!merge) {\r\n" + 
			"      // Check to see if any required properties are missing.\r\n" + 
			"      if (obj === null) {\r\n" + 
			"        broadcastEvent(EVENTS.ERROR, 'Required object not provided.', action);\r\n" + 
			"        return false;\r\n" + 
			"      } else {\r\n" + 
			"        for (var i in validators) {\r\n" + 
			"          if (validators.hasOwnProperty(i) && obj[i] === undefined) {\r\n" + 
			"            broadcastEvent(EVENTS.ERROR, 'Object is missing required property: ' + i + '.', action);\r\n" + 
			"            return false;\r\n" + 
			"          }\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    for (var prop in obj) {\r\n" + 
			"      var validator = validators[prop];\r\n" + 
			"      var value = obj[prop];\r\n" + 
			"      if (validator && !validator(value)) {\r\n" + 
			"        // Failed validation.\r\n" + 
			"        broadcastEvent(EVENTS.ERROR, 'Value of property ' + prop + ' is invalid.',\r\n" + 
			"          action);\r\n" + 
			"        return false;\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"    return true;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var expandPropertyValidators = {\r\n" + 
			"    width: function(v) { return !isNaN(v) && v >= 0; },\r\n" + 
			"    height: function(v) { return !isNaN(v) && v >= 0; },\r\n" + 
			"    useCustomClose: function(v) { return (typeof v === 'boolean'); },\r\n" + 
			"    lockOrientation: function(v) { return (typeof v === 'boolean'); }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  //////////////////////////////////////////////////////////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  bridge.addEventListener('change', function(properties) {\r\n" + 
			"    for (var p in properties) {\r\n" + 
			"      if (properties.hasOwnProperty(p)) {\r\n" + 
			"        var handler = changeHandlers[p];\r\n" + 
			"        handler(properties[p]);\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  });\r\n" + 
			"\r\n" + 
			"  bridge.addEventListener('error', function(message, action) {\r\n" + 
			"    broadcastEvent(EVENTS.ERROR, message, action);\r\n" + 
			"  });\r\n" + 
			"\r\n" + 
			"  bridge.addEventListener('ready', function() {\r\n" + 
			"    broadcastEvent(EVENTS.READY);\r\n" + 
			"  });\r\n" + 
			"\r\n" + 
			"  //////////////////////////////////////////////////////////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  mraid.addEventListener = function(event, listener) {\r\n" + 
			"    if (!event || !listener) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'Both event and listener are required.', 'addEventListener');\r\n" + 
			"    } else if (!contains(event, EVENTS)) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'Unknown MRAID event: ' + event, 'addEventListener');\r\n" + 
			"    } else {\r\n" + 
			"      if (!listeners[event]) listeners[event] = new EventListeners(event);\r\n" + 
			"      listeners[event].add(listener);\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.close = function() {\r\n" + 
			"    if (state === STATES.HIDDEN) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'Ad cannot be closed when it is already hidden.',\r\n" + 
			"        'close');\r\n" + 
			"    } else bridge.executeNativeCall('close');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.expand = function(URL) {\r\n" + 
			"    if (this.getState() !== STATES.DEFAULT) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'Ad can only be expanded from the default state.', 'expand');\r\n" + 
			"    } else {\r\n" + 
			"      var args = ['expand'];\r\n" + 
			"\r\n" + 
			"      if (this.getHasSetCustomClose()) {\r\n" + 
			"        args = args.concat(['shouldUseCustomClose', expandProperties.useCustomClose ? 'true' : 'false']);\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      if (this.getHasSetCustomSize()) {\r\n" + 
			"        if (expandProperties.width >= 0 && expandProperties.height >= 0) {\r\n" + 
			"          args = args.concat(['w', expandProperties.width, 'h', expandProperties.height]);\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      if (typeof expandProperties.lockOrientation !== 'undefined') {\r\n" + 
			"        args = args.concat(['lockOrientation', expandProperties.lockOrientation]);\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      if (URL) {\r\n" + 
			"        args = args.concat(['url', URL]);\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      bridge.executeNativeCall.apply(this, args);\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getHasSetCustomClose = function() {\r\n" + 
			"      return hasSetCustomClose;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getHasSetCustomSize = function() {\r\n" + 
			"      return hasSetCustomSize;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getExpandProperties = function() {\r\n" + 
			"    var properties = {\r\n" + 
			"      width: expandProperties.width,\r\n" + 
			"      height: expandProperties.height,\r\n" + 
			"      useCustomClose: expandProperties.useCustomClose,\r\n" + 
			"      isModal: expandProperties.isModal\r\n" + 
			"    };\r\n" + 
			"    return properties;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getPlacementType = function() {\r\n" + 
			"    return placementType;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getState = function() {\r\n" + 
			"    return state;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getVersion = function() {\r\n" + 
			"    return mraid.VERSION;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.isViewable = function() {\r\n" + 
			"    return isViewable;\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.open = function(URL) {\r\n" + 
			"    if (!URL) broadcastEvent(EVENTS.ERROR, 'URL is required.', 'open');\r\n" + 
			"    else bridge.executeNativeCall('open', 'url', URL);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.removeEventListener = function(event, listener) {\r\n" + 
			"    if (!event) broadcastEvent(EVENTS.ERROR, 'Event is required.', 'removeEventListener');\r\n" + 
			"    else {\r\n" + 
			"      if (listener && (!listeners[event] || !listeners[event].remove(listener))) {\r\n" + 
			"        broadcastEvent(EVENTS.ERROR, 'Listener not currently registered for event.',\r\n" + 
			"          'removeEventListener');\r\n" + 
			"        return;\r\n" + 
			"      } else if (listeners[event]) listeners[event].removeAll();\r\n" + 
			"\r\n" + 
			"      if (listeners[event] && listeners[event].count === 0) {\r\n" + 
			"        listeners[event] = null;\r\n" + 
			"        delete listeners[event];\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.setExpandProperties = function(properties) {\r\n" + 
			"    if (validate(properties, expandPropertyValidators, 'setExpandProperties', true)) {\r\n" + 
			"      if (properties.hasOwnProperty('width') || properties.hasOwnProperty('height')) {\r\n" + 
			"        hasSetCustomSize = true;\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      if (properties.hasOwnProperty('useCustomClose')) hasSetCustomClose = true;\r\n" + 
			"\r\n" + 
			"      var desiredProperties = ['width', 'height', 'useCustomClose', 'lockOrientation'];\r\n" + 
			"      var length = desiredProperties.length;\r\n" + 
			"      for (var i = 0; i < length; i++) {\r\n" + 
			"        var propname = desiredProperties[i];\r\n" + 
			"        if (properties.hasOwnProperty(propname)) expandProperties[propname] = properties[propname];\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.useCustomClose = function(shouldUseCustomClose) {\r\n" + 
			"    expandProperties.useCustomClose = shouldUseCustomClose;\r\n" + 
			"    hasSetCustomClose = true;\r\n" + 
			"    bridge.executeNativeCall('usecustomclose', 'shouldUseCustomClose', shouldUseCustomClose);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  // MRAID 2.0 APIs ////////////////////////////////////////////////////////////////////////////////\r\n" + 
			"\r\n" + 
			"  mraid.createCalendarEvent = function(parameters) {\r\n" + 
			"    CalendarEventParser.initialize(parameters);\r\n" + 
			"    if (CalendarEventParser.parse()) {\r\n" + 
			"      bridge.executeNativeCall.apply(this, CalendarEventParser.arguments);\r\n" + 
			"    } else {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, CalendarEventParser.errors[0], 'createCalendarEvent');\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.supports = function(feature) {\r\n" + 
			"    return supports[feature];\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.playVideo = function(uri) {\r\n" + 
			"    if (!mraid.isViewable()) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'playVideo cannot be called until the ad is viewable', 'playVideo');\r\n" + 
			"      return;\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    if (!uri) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'playVideo must be called with a valid URI', 'playVideo');\r\n" + 
			"    } else {\r\n" + 
			"      bridge.executeNativeCall.apply(this, ['playVideo', 'uri', uri]);\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.storePicture = function(uri) {\r\n" + 
			"    if (!mraid.isViewable()) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'storePicture cannot be called until the ad is viewable', 'storePicture');\r\n" + 
			"      return;\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    if (!uri) {\r\n" + 
			"      broadcastEvent(EVENTS.ERROR, 'storePicture must be called with a valid URI', 'storePicture');\r\n" + 
			"    } else {\r\n" + 
			"      bridge.executeNativeCall.apply(this, ['storePicture', 'uri', uri]);\r\n" + 
			"    }\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.resize = function() {\r\n" + 
			"    bridge.executeNativeCall('resize');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getResizeProperties = function() {\r\n" + 
			"    bridge.executeNativeCall('getResizeProperties');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.setResizeProperties = function(resizeProperties) {\r\n" + 
			"    bridge.executeNativeCall('setResizeProperties', 'resizeProperties', resizeProperties);\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getCurrentPosition = function() {\r\n" + 
			"    bridge.executeNativeCall('getCurrentPosition');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getDefaultPosition = function() {\r\n" + 
			"    bridge.executeNativeCall('getDefaultPosition');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getMaxSize = function() {\r\n" + 
			"    bridge.executeNativeCall('getMaxSize');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  mraid.getScreenSize = function() {\r\n" + 
			"    bridge.executeNativeCall('getScreenSize');\r\n" + 
			"  };\r\n" + 
			"\r\n" + 
			"  var CalendarEventParser = {\r\n" + 
			"    initialize: function(parameters) {\r\n" + 
			"      this.parameters = parameters;\r\n" + 
			"      this.errors = [];\r\n" + 
			"      this.arguments = ['createCalendarEvent'];\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parse: function() {\r\n" + 
			"      if (!this.parameters) {\r\n" + 
			"        this.errors.push('The object passed to createCalendarEvent cannot be null.');\r\n" + 
			"      } else {\r\n" + 
			"        this.parseDescription();\r\n" + 
			"        this.parseLocation();\r\n" + 
			"        this.parseSummary();\r\n" + 
			"        this.parseStartAndEndDates();\r\n" + 
			"        this.parseReminder();\r\n" + 
			"        this.parseRecurrence();\r\n" + 
			"        this.parseTransparency();\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      var errorCount = this.errors.length;\r\n" + 
			"      if (errorCount) {\r\n" + 
			"        this.arguments.length = 0;\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      return (errorCount === 0);\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseDescription: function() {\r\n" + 
			"      this._processStringValue('description');\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseLocation: function() {\r\n" + 
			"      this._processStringValue('location');\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseSummary: function() {\r\n" + 
			"      this._processStringValue('summary');\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseStartAndEndDates: function() {\r\n" + 
			"      this._processDateValue('start');\r\n" + 
			"      this._processDateValue('end');\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseReminder: function() {\r\n" + 
			"      var reminder = this._getParameter('reminder');\r\n" + 
			"      if (!reminder) {\r\n" + 
			"        return;\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      if (reminder < 0) {\r\n" + 
			"        this.arguments.push('relativeReminder');\r\n" + 
			"        this.arguments.push(parseInt(reminder) / 1000);\r\n" + 
			"      } else {\r\n" + 
			"        this.arguments.push('absoluteReminder');\r\n" + 
			"        this.arguments.push(reminder);\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseRecurrence: function() {\r\n" + 
			"      var recurrenceDict = this._getParameter('recurrence');\r\n" + 
			"      if (!recurrenceDict) {\r\n" + 
			"        return;\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      this.parseRecurrenceInterval(recurrenceDict);\r\n" + 
			"      this.parseRecurrenceFrequency(recurrenceDict);\r\n" + 
			"      this.parseRecurrenceEndDate(recurrenceDict);\r\n" + 
			"      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInWeek');\r\n" + 
			"      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInMonth');\r\n" + 
			"      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInYear');\r\n" + 
			"      this.parseRecurrenceArrayValue(recurrenceDict, 'monthsInYear');\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseTransparency: function() {\r\n" + 
			"      var validValues = ['opaque', 'transparent'];\r\n" + 
			"\r\n" + 
			"      if (this.parameters.hasOwnProperty('transparency')) {\r\n" + 
			"        var transparency = this.parameters['transparency'];\r\n" + 
			"        if (contains(transparency, validValues)) {\r\n" + 
			"          this.arguments.push('transparency');\r\n" + 
			"          this.arguments.push(transparency);\r\n" + 
			"        } else {\r\n" + 
			"          this.errors.push('transparency must be opaque or transparent');\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseRecurrenceArrayValue: function(recurrenceDict, kind) {\r\n" + 
			"      if (recurrenceDict.hasOwnProperty(kind)) {\r\n" + 
			"        var array = recurrenceDict[kind];\r\n" + 
			"        if (!array || !(array instanceof Array)) {\r\n" + 
			"          this.errors.push(kind + ' must be an array.');\r\n" + 
			"        } else {\r\n" + 
			"          var arrayStr = array.join(',');\r\n" + 
			"          this.arguments.push(kind);\r\n" + 
			"          this.arguments.push(arrayStr);\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseRecurrenceInterval: function(recurrenceDict) {\r\n" + 
			"      if (recurrenceDict.hasOwnProperty('interval')) {\r\n" + 
			"        var interval = recurrenceDict['interval'];\r\n" + 
			"        if (!interval) {\r\n" + 
			"          this.errors.push('Recurrence interval cannot be null.');\r\n" + 
			"        } else {\r\n" + 
			"          this.arguments.push('interval');\r\n" + 
			"          this.arguments.push(interval);\r\n" + 
			"        }\r\n" + 
			"      } else {\r\n" + 
			"        // If a recurrence rule was specified without an interval, use a default value of 1.\r\n" + 
			"        this.arguments.push('interval');\r\n" + 
			"        this.arguments.push(1);\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseRecurrenceFrequency: function(recurrenceDict) {\r\n" + 
			"      if (recurrenceDict.hasOwnProperty('frequency')) {\r\n" + 
			"        var frequency = recurrenceDict['frequency'];\r\n" + 
			"        var validFrequencies = ['daily', 'weekly', 'monthly', 'yearly'];\r\n" + 
			"        if (contains(frequency, validFrequencies)) {\r\n" + 
			"          this.arguments.push('frequency');\r\n" + 
			"          this.arguments.push(frequency);\r\n" + 
			"        } else {\r\n" + 
			"          this.errors.push('Recurrence frequency must be one of: \"daily\", \"weekly\", \"monthly\", \"yearly\".');\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    parseRecurrenceEndDate: function(recurrenceDict) {\r\n" + 
			"      var expires = recurrenceDict['expires'];\r\n" + 
			"\r\n" + 
			"      if (!expires) {\r\n" + 
			"        return;\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      this.arguments.push('expires');\r\n" + 
			"      this.arguments.push(expires);\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    _getParameter: function(key) {\r\n" + 
			"      if (this.parameters.hasOwnProperty(key)) {\r\n" + 
			"        return this.parameters[key];\r\n" + 
			"      }\r\n" + 
			"\r\n" + 
			"      return null;\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    _processStringValue: function(kind) {\r\n" + 
			"      if (this.parameters.hasOwnProperty(kind)) {\r\n" + 
			"        var value = this.parameters[kind];\r\n" + 
			"        this.arguments.push(kind);\r\n" + 
			"        this.arguments.push(value);\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"\r\n" + 
			"    _processDateValue: function(kind) {\r\n" + 
			"      if (this.parameters.hasOwnProperty(kind)) {\r\n" + 
			"        var dateString = this._getParameter(kind);\r\n" + 
			"        this.arguments.push(kind);\r\n" + 
			"        this.arguments.push(dateString);\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"  };\r\n" + 
			"}());";
}
