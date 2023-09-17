 oop-2021-uto-18-c-krizan-oliverIzsakGit" Project GameStop by Olivér Izsák

Project GameStop is a system for keeping track of data, demand and orders from different gaming merchandise and video games.

How to use: 1.If you are using it in eclipse simply importing a project from the whole folder should work. 2.Run the start class. 3.Type in a name and password - a config.bin file is created this stores your admin password and name. If you forget your password just delete the config.bin file. 4.After that you can choose to access the program as an admin or as a customer. 5. As an admin you have to log in. 5.1 Then you can create a new product in the store, you can see the products already existing in the store (you can refresh the table to see changes) you can also search for a product or you can delete a product. 5.1. You can go to storage. In storage you can add new products, delete products. And you can go to ordered products. 5.2. In ordered products you can add products in different amounts, you can delete them, or you can add them to the storage. 5.1.1. From the store you can also go to Demands, or Admin logs. 5.1.2. In demands you can see the demand list made by users, you can refresh the list, or you can delete a demand. 6.As customer you dont have to log in. 6.1. As customer you are not able to go back from the main customer page. In this page you can look for products in store by price,name, and console type. 6.2. You can go to demands, to create a demand.

Polymorphism can be found in GamingMerchandise , as I create products I have arraylists of GamingMerchandise, where I can store 3 different objects basically VideoGames,Accessories,Console because all these 3 classes extend GamingMerchandise.

Polymorphism can be found in model factory for example,I use interfaces to access implementations.
Or it can be found in StorageModelImpl, where I call the log() method on User objects.
>>>>>>> refs/remotes/origin/main

Aggregation can be seen in LogLine class for example, its never used without the Log class.

I separated the logic and the GUI by using the Model-View-ViewModel architectural pattern.
