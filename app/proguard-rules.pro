# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-optimizationpasses 5                                                           # 指定代码的迭代优化次数
#-dontusemixedcaseclassnames                                                     # 不使用大小写名称的类名
#-dontskipnonpubliclibraryclasses                                                # 指定不去忽略非公共的库类
#-dontpreverify                                                                  # 混淆时是否做预校验
#-verbose                                                                        # 混淆时是否记录日志
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*        # 优化选项