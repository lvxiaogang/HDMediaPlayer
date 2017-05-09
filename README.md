# HDMediaPlayer
[![Platform](https://img.shields.io/badge/平台-%20Android%20-brightgreen.svg)](https://github.com/yinhaide/HDMediaPlayer/wiki)
[![characteristic](https://img.shields.io/badge/特点-%20轻量级%20%7C%20简单易用%20%20%7C%20稳定%20-brightgreen.svg)](https://github.com/yinhaide/HDMediaPlayer/wiki)
> 该类包依托于谷歌Mediaplayer二次封装。 <br/>
> 谷歌中国API链接:https://developer.android.google.cn/guide/topics/media/mediaplayer.html <br/>

![](https://github.com/yinhaide/HDMediaPlayer/raw/master/resource/readme.gif)

## 目录
* [如何导入到项目](#Import)
* [如何使用](#Use)
* [关于我](#About)
* [License](#License)

<a name="Import"></a>
### 如何导入到项目
> 支持jcenter方式导入。 <br/>
> 支持本地Module方式导入。 <br/>

#### jcenter方式导入

* 在需要用到这个库的module中的build.gradle中的dependencies中加入

```
dependencies {
    compile 'com.yhd.hdmediaplayer:hdmediaplayer:1.0.1'
}
```

#### Module方式导入

* 下载整个工程，将hdmediaplayer拷贝到工程根目录,settings.gradle中加入

```
include ':hdmediaplayer'
```

* 在需要用到这个库的module中的build.gradle中的dependencies中加入

```
dependencies {
    compile project(':hdmediaplayer')
}
```



<a name="Use"></a>
### 如何使用
> 该类支持音乐（.mp3、.wav、.ogg）和视频(.mp4、.3gp)以及对应格式的网络流媒体的播放。 <br/>
> 如果要播放视频的话需要控件:SurfaceView。 <br/>

---

* 一行代码实现播放Assets目录下的mp4:

```
MediaPlayerHelper.getInstance().setSurfaceView((SurfaceView)findViewById(R.id.surfaceView)).playAsset(MainActivity.this,"test.mp4");
```


* 一行代码实现播放Assets目录下的mp3:

```
MediaPlayerHelper.getInstance().playAsset(MainActivity.this,"test.mp3");
```

* 一行代码实现播放网络流媒体或者本地全路径流媒体:

```
/**
 * urlString 可为网络流媒体连接，也可以为本地存储全路径链接
 */
MediaPlayerHelper.getInstance().setSurfaceView((SurfaceView)findViewById(R.id.surfaceView)).play(urlString);
```

* 如果想得到详细的回调信息：

```
MediaPlayerHelper.getInstance().setMediaPlayerHelperCallBack(new MediaPlayerHelper.MediaPlayerHelperCallBack() {
    @Override
    public void onCallBack(MediaPlayerHelper.CallBackState state, MediaPlayerHelper mediaPlayerHelper, Object... args) {
        Log.v(TAG,"--"+state.toString());
        if(state== MediaPlayerHelper.CallBackState.PROGRESS){
            int percent=(int)args[0];
            Log.v(TAG,"--progress:"+percent);
        }
    }
});
```

* 更多的用法请查看demo:

```
/** 设置播放进度回调时间间隔 */
MediaPlayerHelper.getInstance().setProgressInterval(msec);
/** 获得MediaPlayer对象，进行更多的自定义的操作 */
MediaPlayerHelper.getInstance().getMediaPlayer().pause();
MediaPlayerHelper.getInstance().getMediaPlayer().start();
MediaPlayerHelper.getInstance().getMediaPlayer().stop();
```

<a name="About"></a>
### 关于我

    欢迎 Star Fork
    交流地址：尹海德（123302687@qq.com）

<a name="License"></a>
### License

    Copyright 2017 Yinhaide
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.