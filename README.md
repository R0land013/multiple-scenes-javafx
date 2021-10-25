# Multiple Scenes JavaFX

This is a **demo** about showing a way to create a multiple scene **JavaFX** application
using **MVP**.

If you are not familiarized with **MVP** you should first understand it.
You can read about it [here](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) .


## About

I was finding a way to create a **JavaFX** application using only one **window or stage**, and
multiple **scenes**. The way I wanted to achieve it, was creating a mechanism to manage
the **presenters** using a stack. Doing that I could navigate between the **presenters**
and the **scenes** in a common manner, openig new pairs of **presenter** and **view**,
and being able to return to previous opened **presenters**.

And I wanted to got it without making a great effort in every **presenter** source code.


## The Solution

### Principal Classes and Interfaces

#### PresenterManager:

This is the most important class. It manage the *transitions* between presenters.
The **presenters** notify this class to add **presenters** or close them.


#### AbstarctPresenter:

All **presenters** must extends this class, because it defines the interfaces to
comunicate with the **PresenterManager** class. This class use **notifyManagerToAddNewPresenter()**
and **notifyManagerToDeletePresenter()** methods to achieve it. These method are *protected*.


#### PresenterView:

All **views** must implement this *interface*. It has the method **getViewScene()** to retrieve the
**javafx.scene.Scene** object from the **view** object. This method is used by
the **PresenterManager** to set the visible **scene**.


### Explaining the mechanism

**First**, all **presenters** classes must extends the **AbstarctPresenter** class and implement
all *abstract* methods:

> **getDerivedPresenter():** is used by **PresenterManager** to retrieve a **new presenter**
> to be opened. Inside this method you can use a *switch* statement or something similar to
> return an instance of the wished **presenter**, because one **presenter** could open
> different **presenters**. For example you could have an application which shows a window
> with two button, the first to open a CRUD **scene** of products and the other a CRUD
> **scene** of clients. 


> **getPresenterView():** is used by **PresenterManager** to retrieve the **PresenterView**
> of the **presenter** to be opened. And then get the **javafx.scene.Scene** from it.


**Second**, you have to implement methods which calls **notifyManagerToAddNewPresenter()**
and **notifyManagerToDeletePresenter()** to add new **presenter** and delete current **presenter**
respectively. *See the source code of this project*.


**Third**, in the **views** of your **presenters** you have to set the *listeners* in *buttons* or *widgets*
you want to fire the *events* of opening or closing **presenters**, and bind it with the methods created
in the *previous step*. And you have to implement the **getViewScene()** method to return the **javafx.scene.Scene**
from this **view** object. *See the source code of this project*.


**Fourth**, in the **start(Stage)** method of your **Main** class create an instance of **PresenterManager**
and set the *initial presenter* with **setInitialPresenter(AbstarctPresenter)**. Then you can call the
**show()** method of **AbstarctPresenter** to show the **stage** or **window** of your application.

*You can always check the source code of this project, if you did not understand this description.*


## Images of the demo


### First scene

![alt text](https://github.com/R0land013/multiple-scenes-javafx/blob/main/first_scene.png)


### Second Scene

![alt text](https://github.com/R0land013/multiple-scenes-javafx/blob/main/second_scene.png)


### Third Scene

![alt text](https://github.com/R0land013/multiple-scenes-javafx/blob/main/third_scene.png)