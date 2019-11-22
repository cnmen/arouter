### Hello, Do you know about component development ?
#### If you don't know, please click here : [CmonBaby](https://www.cmonbaby.com/posts/netease_modular.html)

## Arouter ![Build Status](https://travis-ci.org/greenrobot/EventBus.svg?branch=master)

* Simplifies to devleper between components
* Makes your code simpler
* Very simple configuration
* Lightweight (~32k jar)

## Arouter in 4 steps

#### 1. Setting build.gradle (android application / android library):
```gradle
def moduleName = project.name
android {
    // ......
    defaultConfig {
        // ......

        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [moduleName: moduleName]
            }
        }
    }
    buildTypes {
        release {
            // ......
        }
    }
}
```

#### 2. Add class annotation as route
```java
@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {}
```

#### 3. Intent and carry params
```java
RouterManager.getInstance() // singleton
        // Arouter path
        .build("/library/LibraryActivity")
        // String
        .withString("name", "simon")
        // Basic data type
        .withInt("key", value)
        .withBoolean("key", value)
        .withByte("key", value)
        .withChar("key", value)
        .withDouble("key", value)
        .withFloat("key", value)
        .withLong("key", value)
        .withShort("key", value)
        // Serializable and Parcelable
        .withSerializable("key", value)
        .withParcelable("key", value)
        // Bundle
        .withBundle("key", value)
        // Activate the callback
        .withResultString("key", value)
        // Intent jump
        .navigation(this, requestCode) // startActivityForResult()
        .navigation(this, resultCode) // setResult() + finish()
        .navigation(this); // startActivity()
```

#### 4. About Parameters
```java
@ARouter(path = "/library/LibraryActivity")
public class LibraryActivity extends AppCompatActivity {

    @Parameter // Parameter name = Field name
    String name;
    
    @Parameter(name = "totalCount") // Custom parameter name
    int count;
    
    @Parameter
    PersonalInfo info; // Javabean (must be 'implements Serializable or Parcelable')
    
    @Parameter
    CustomInterface internal; // Public interface (must be 'extends Call')

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ParameterManager.getInstance().loadParameter(this); // Lazy loading
        Log.e("simon >>> ", name);
    }
}
```

## Add Arouter to your project
<a href="https://www.cmonbaby.com/posts/netease_modular.html">
<img src="https://img.shields.io/bintray/v/cmonbaby/simon/arouter_annotation?label=maven-central"></a>

Via Gradle:
```gradle
implementation 'com.cmonbaby.arouter.core:arouter_core:2.1.1'
implementation 'com.cmonbaby.arouter.annotation:arouter_annotation:2.1.1'
annotationProcessor 'com.cmonbaby.arouter.compiler:arouter_compiler:2.1.1'
```

Via Maven:
```xml
<dependency>
    <groupId>com.cmonbaby.arouter.annotation</groupId>
    <artifactId>arouter_annotation</artifactId>
    <version>2.1.1</version>
</dependency>
<dependency>
    <groupId>com.cmonbaby.arouter.compiler</groupId>
    <artifactId>arouter_compiler</artifactId>
    <version>2.1.1</version>
</dependency>
<dependency>
    <groupId>com.cmonbaby.arouter.core</groupId>
    <artifactId>arouter_core</artifactId>
    <version>2.1.1</version>
</dependency>
```

## License

Copyright (C) 2013-2020 Markus Junginger, Simon (https://www.cmonbaby.com)  
Arouter binaries and source code can be used according to the [Apache License, Version 2.0](LICENSE).
