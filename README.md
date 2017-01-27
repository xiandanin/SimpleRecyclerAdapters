# android-adapters

###示例截图
![](/screenshots/example.png)

###示例apk
[下载](https://github.com/dengyuhan/android-adapters/releases/download/1.0.0/example_1.0.0.apk)<br/>
![](/screenshots/qrcode.png)

##快速开始

###Android Studio - 在build.gradle中引入
```java
//必选
compile 'com.dyhdyh.adapters:adapters:1.0.0'
//如果需要支持DataBinding(可选)
compile 'com.dyhdyh.adapters:adapters-databinding:1.0.0'
```
###需要的依赖
```java
compile 'com.android.support:recyclerview-v7:24.2.1'
```
<br/>

###模板安装
1.下载打包好的[templates](https://github.com/dengyuhan/android-adapters/releases/download/1.0.0/templates_1.0.0.zip)或者找到源码中的templates文件夹<br/><br/>
2.将templates文件夹里的`adapters`整个复制到AndroidStudio模板目录下<br/>

Windows：晚点补充<br/>
Mac：/Applications/Android Studio.app/Contents/plugins/android/lib/templates
<br/><br/>
3.重启Android Studio
<br/>

###快速生成
![](/screenshots/new_adapter.png)<br/>
![](/screenshots/new_adapter_2.png)<br/>
###生成出来的代码
体力活都自动做好了,我们要写的就只有绑定数据了<br/>
![](/screenshots/new_adapter_3.png)<br/>
<br/>
###RecyclerView和ListView的相互转换
当需要将RecyclerAdapter转成ListAdapter的时候,把这两个类名改一下就可以了<br/>
![](/screenshots/new_adapter_4.png)<br/>
<br/>

####更多用法可以看例子工程
<br/>

######Android交流QQ群:146262062
######http://dyhdyh.com/

