# FunctionInterface
一个面向Fragment和Activity的万能j通信框架，四个接口覆盖所有参数和返回值的情况。

两行代码即可实现数据通信传输，只用写自己要实现的逻辑代码即可。


# 最新版本

版本号：[![](https://www.jitpack.io/v/YouAreOnlyOne/FunctionInterface.svg)](https://www.jitpack.io/#YouAreOnlyOne/FunctionInterface)

使用自行替换下面的版本号，以获得最新版本。



# 使用方法

这里分别介绍在不同项目环境中，如何引用对该库的依赖。

## Android中使用：

方法一：

1.第一步，在项目的build.gradle下配置，注意是项目的build.gradle：

     allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
    
    
2.第二步,在app的build.gradle下添加如下依赖：

    dependencies {
            ...
            implementation 'com.github.YouAreOnlyOne:FunctionInterface:版本号'
            ...
     }
    
    
方法二：
    
 1.第一步，下载依赖的包：https://github.com/YouAreOnlyOne/FunctionInterface/blob/master/source/functioninterface-release.aar 。并放到项目的 libs 目录下面。
    
 2.第二步,在app的build.gradle下添加如下依赖，注意，两个依赖是平级关系：
    
    repositories {
       flatDir {
           dirs 'libs'
         }
    }
    
    dependencies {
            ...
            compile(name:'andfix-release', ext:'aar')
            ...
    }
 

	
# 使用示例：

1、在Android项目中，在MainActivity中加载了若干Fragment，此时需要实现通信，只需要简单的进行下面的步骤即可完成：

2、所有的Fragment继承框架的BaseFragment，并在每个Fragment中定义接口名称，注意接口名称保证唯一，一般建议如下定义：

   public static final String INTERFACE_FUNCTION_NAME = BlankFragment.class.getName()+"一个字符名称";
	
3、在Fragment中使用方法，也只需要一行代码进行调用，如下：

  functionsManager.invokeFunction(INTERFACE_FUNCTION_NAME);

4、在MainActivity中继承框架的BaseActivity，此时需要继承对应的抽象方法，并在方法中使用如下两行代码：

	  @Override
    public void setFunctionsForFragment(int id) {
        //下面两行代码是需要实现的
        BaseFragment baseFragment=(BaseFragment)fragmentManager.findFragmentById(id);
        //addFunction()中new 后面的接口，根据自己的实际需要进行选择，如不需要参数不需要返回值，则像下面所示，其它的四个接口可以灵活选择
        baseFragment.setFunctionsManager(functionsManager.addFunction(new FunctionNoParameterNoResult("Fragment中对应的接口名称，步骤2所示")));
        
        
        
此时，只需要书写自己方法的逻辑代码即可，如下所示：

     @Override
    public void setFunctionsForFragment(int id) {
        BaseFragment baseFragment=(BaseFragment)fragmentManager.findFragmentById(id);
        baseFragment.setFunctionsManager(functionsManager.addFunction(new FunctionNoParameterNoResult(INTERFACE_FUNCTION_NAME) {
            @Override
            public void function() {
                //要实现的方法的逻辑代码
                Toast.makeText(MainActivity.this,"test method",Toast.LENGTH_LONG).show();
            }
        }));

	
	
如有对网络请求、上传、下载等相关网络操作不熟悉的，可以参考一下下面的文章：

OkHttp 、Retrofit 、Volley 、RxJava、Novate在Android中Web网络请求一行代码解决。

https://blog.csdn.net/u014374009/article/details/82933127

一行代码实现Ftp文件上传、文件下载、文件删除和进度监听的工具类的使用。

https://blog.csdn.net/u014374009/article/details/82944107

 
 
# 项目用到的权限

  在manifest文件中添加访问的权限：
 

    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

   

 
# 使用指南
 
 更新中……
 
# 相关介绍

一行代码解决AndFix热修复和热跟更新问题，集成了阿里的开源库，修复程序的缺陷bug漏洞和功能页面等.

https://blog.csdn.net/u014374009/article/details/83052178




# 其它信息

1.项目还有很多不完善的地方，欢迎大家指导。

2.项目持续更新开源，有兴趣加入项目或者跟随项目的伙伴，可以邮件联系！ 

3.关注或者喜欢或者尝试使用或者感兴趣的伙伴可以，点击 ~ star ~ 。

# 作者邮箱

ycj52011@outlook.com


