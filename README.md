# weatherReportDemo1
本人初学，这是我个人在学习过程中的个人理解和总结。欢迎各位大佬前来赐教，分享你们的个人理解和方法，本人在此感激不尽~~
# 天气预报项目 使用MVP
## 什么是MVP设计模式? what is an MVP design patten?

### MVP 将应用程序分为三个基本组件
1. Model：主要负责应用程序的数据部分
2. View： 负责在屏幕上显示有特定数据的布局视图
3. Presenter: 这是连接Model 和 View 的桥梁，还有是通知UI更新的扮演者。

#### MVP根据上述提及内容提出几个规则，如下
1. View 唯一的职责就是根据Presenter的通知去绘制UI，就是只听Presenter，其他都使唤不了他。
2. View 将所有的用户交互委托给Presenter ,我个人理解是向Presenter请求数据
3. View 无法直接跟Model层进行通信
4. Presenter 负责将View的请求委托至Model，然后根据特定的事件动作通知View做出更新
5. Model 负责从服务器，数据库，文件系统中获取数据


### View层 
比如 Fragment 一般都是要实现 用于通知UI更新的CallBack接口(MVPView) 也就是implement xxx
接口里写一个方法，参数一般都是写入我们要传的数据。目的是我们调用这个方法以致能够将数据给到VIEW实现UI的更新
比如 项目中的SelectAreaFragment 在这里面我们要完成
- initView 加载View 目的，就是要显示视图在屏幕上
 - - 如果要用到适配器的话，你应当创建适配器 然后设置适配器 
- initPresenter 加载presenter
- - 很明显我们是MVP，若是没有presenter怎么获取数据，怎么去更新UI，是吧。所以这里我们需要写一个接口，里面是我们presenter需要实现的几个方法，其中方法有

1. 获取数据的
2. 注册通知UI更新的接口
3. 注销通知UI的接口() 

然后实现类去实现这个接口，然后怎么获取数据的就看实际情况去写了。就比如我这里是使用retrofit获取数据，获取到数据后，我们就使用通知UI更新的那个接口实现将数据传到UI层。这个接口在我们加载presenter的时候就需要注册一下，就是调用registerCallBack。在这之前，需要我们在这个fragment去实现通知UI更新的接口了。这一实现，数据就从这个方法回来了，我们根据这个方法传来的数据打印，就能够看出数据了。
- loadData 加载数据 就是根据我们的presenter去获取数据
- - 这里我们就调用实现类的方法，因为我们presenter中实现类方法就是去获取数据的嘛。方法中又根据我们写的通知UI更新的接口，将数据从这个接口拿到UI去。不管怎么样，我们需要调用这个方法去获取数据。将调用这个方法的代码注释掉，你会发现，adapter中获取的数据就是0了。

    
