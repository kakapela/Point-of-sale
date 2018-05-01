# Point-of-sale
## Implementation a simple point of sale.

### About project

Implement a simple point of sale.


Assume you have: 

– one input device: bar codes scanner 

– two output devices: LCD display and printer

Implement: 

– single product sale: products bar code is scanned and:

  * if the product is found in products database than it's name and price is printed on LCD display 

  * if the product is not found than error message 'Product not found' is printed on LCD display 

  * if the code scanned is empty than error message 'Invalid bar-code' is printed on LCD display 

– when 'exit' is input than receipt is printed on printer containing a list of all previously scanned items names and prices as well as total sum to be paid for all items; the total sum is also printed on LCD display




---

### Features

* Using DAO, Simple Factory and Singleton design patterns

* MVC architecture

* mocking simple database using **SQLite**

* built with Maven

* GUI created using JavaFX and libraries: JFoenix, FontAwesomeFX 

* tests using JUnit

---

### Database

```

Simple database made in SQLite contains data to tests:

96363533, 'bread',1.88

74017816, 'butter',1.15

17350415, 'milk',2.15
                                      
50486750, 'yogurt',1.05

63529719, 'meat',5.05

33010091, 'corn-flakes',3.05

56218217, 'water',2.21

```

---

### Screenshots

![app1](https://user-images.githubusercontent.com/34391192/39486382-364f6b42-4d7c-11e8-8b00-f9aadce8deb0.PNG)


![app2](https://user-images.githubusercontent.com/34391192/39486385-3901cfa6-4d7c-11e8-8a5b-d167b36b13ce.PNG)


![app3](https://user-images.githubusercontent.com/34391192/39486390-3b33cf0e-4d7c-11e8-8f45-e52011498688.PNG)


![app4](https://user-images.githubusercontent.com/34391192/39486394-3d03f854-4d7c-11e8-9a17-f6fa6cb3ab13.PNG)








