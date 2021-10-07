# AntiqueMall
![appicon](https://github.com/oguz-sahin/AntiqueMall/blob/develop/app/src/main/res/mipmap-xhdpi/ic_app_icon.png)

AntiqueMall is a simple shopping app, which uses some Huawei Kits to sign in([Account Kit](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-introduction-0000001098842325)), catch crash([Crash Service](https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/agc-crash-introduction-0000001055732708)), report user behavior([Analytic Kit](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050745149)), showing location on map([Map Kit](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-sdk-introduction-0000001061991291)) , showing advertisement([Ads Kit](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/publisher-service-introduction-0000001070671805)). The main goal of this app is to be a sample of how to use Huawei Kits with high quality Android application that uses the Architecture components, Hilt etc. in Kotlin.

<h2 id="Outputs">Outputs</h2>


## Libraries and tools 🛠

<li><a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-introduction-0000001098842325">Account Kit</a></li>
<li><a href="https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/agc-crash-introduction-0000001055732708">Crash Service</a></li>
<li><a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050745149">Analytic Kit</a></li>
<li><a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-sdk-introduction-0000001061991291">Map Kit</a></li>
<li><a href="https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/publisher-service-introduction-0000001070671805">Ads Kit</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/navigation/">Navigation</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/livedata">LiveData</a></li>
<li><a href="https://developer.android.com/topic/libraries/data-binding">Data Binding</a></li>
<li><a href="https://developer.android.com/topic/libraries/view-binding">View Binding</a></li>
<li><a href="https://developer.android.com/training/dependency-injection/hilt-android">Hilt</a></li>
<li><a href="https://bumptech.github.io/glide/">Glide</a></li>
<li><a href="https://material.io/develop/android/docs/getting-started/">Material Design</a></li>
<li><a href="https://github.com/tommybuonomo/dotsindicator">Dots Indicator</a></li>
<li><a href="https://github.com/intuit/sdp">Sdp</a></li>




## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture to have a unidirectional flow of data, separation of concern, and a lot more which is recommended by Google itself.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)


<h2 id="license">License</h2>
<pre><code>

Copyright (c) 2021 Oğuz Şahin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
</code></pre>