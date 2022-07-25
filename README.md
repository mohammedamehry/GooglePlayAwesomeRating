[![](https://jitpack.io/v/mohammedamehry/GooglePlayRating.svg)](https://jitpack.io/#mohammedamehry/GooglePlayRating)

# Google Play Awsome Rating Library

An Easy Android Library tha help you get reviews and ratings for your android app and it's easy to implement.

![Native Example](https://github.com/mohammedamehry/GooglePlayAwesomeRating/blob/f554b3332ca078529ceb05f3548e10a546a30b1e/screenshot.png)

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
*Step 2.* Add the dependency 
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
            Amehry.ShowRating(this,true,"mohammedamehry@domain.com");
        });
```
#### Library Attributes
| Attribute | Description |
| --- | --- |
| `Activity` | `Activity` Your Activity Context |
| `shouldReceiveFeedback` | `Boolean` If it's true then the user will have to fill ¡n feedback form -- if it's false the feedback form will be dismissed  |
| `FeedbackEmail` | `String` Your email address in which you will receive users feedback if they choose to send it |

## License
    Copyright 2022 Mohammed Amehry

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.





