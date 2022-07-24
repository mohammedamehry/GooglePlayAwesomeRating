[![](https://jitpack.io/v/mohammedamehry/GooglePlayRating.svg)](https://jitpack.io/#mohammedamehry/GooglePlayRating)

# Google Play Awsome Rating Library

An Easy Android Library tha help you get reviews and ratings for your android app and it's easy to implement.

## Installation :

*Step 1.* Add the JitPack repository to your project `build.gradle` file
```gradle
allprojects {
    repositories {
        //your repository
        maven { url 'https://jitpack.io' }
    }
}
```
*Step 2.* Add the dependency in the form
```gradle
dependencies {
  implementation 'com.github.mohammedamehry:GooglePlayAwesomeRating:version1.0'
}
```

## Initialize
You can show the rating dialog by using this line of code:

```java
Amehry.ShowRating(this,true,"uremail@mail.com");
```

in this example i implemented it inside a button :

```java
ShowAd.setOnClickListener(view -> {
            Amehry.ShowRating(this,true,"Mohammedamehry@icloud.com");
        });
```
#### Library Attributes
| Attribute | Description |
| --- | --- |
| `Activity` | `Activity` Your Activity Context |
| `shouldReceiveFeedback` | `Boolean` If it's true then the user will have to fill ¡n feedback form -- if it's false the feedback form will be dismissed  |
| `FeedbackEmail` | `String` Your email address in which you will receive users feedback if they choose to send it |







