# Stock Trading

Source: https://leetcode.com/discuss/interview-question/613466/Design-a-stock-trading-system

```java
public interface Publisher {
  public void setStockValue(int value);
  public void registerObserver(Observer observer);
  public void unRegisterObserver(Observer observer);
  public void notifyAllObservers();
}
Subscriber(Observer) Interface:


public interface Observer {
   public void update(int newValue);
   public void display();
   public void unSubscribe();
}
StockMarket Class which implements the Publisher interface:


public class StockMarket : Publisher {
  Set<Observer> observers;
  int newValue;

  public StockMarket() {
	observers = new HashSet<Observer>();
	newValue = 0;
  }  
  
  public void setStockValue(int value){
    newValue = value;
  }
  
  public void registerObserver(Observer observer){
    observers.add(observer);
  }

  public void unRegisterObserver(Observer observer){
    if(observer != null && observer instanceof Observer){
	    observers.remove(observer);
	}
  }

  public void notifyAllObservers(){
	Iterator<Observer> observerIterator = observers.iterator();
	while(observerIterator.hasNext()){
		Observer observer = observerIterator.next();
		observer.update(this, null);
	}
  }
}
As a sample i will implement the PayPalStock which implements the Observer Interface. This inturn maintains a reference to the Publisher.


public class PayPalStock : Observer {
   Publisher stockMarket;
   int latestValue;

   public PayPalStock (Publisher subject){
   	latestValue = 0;
    stockMarket = subject;
    stockMarket.registerObserver(this); // Self-Registering to the Publisher
   }

   public void update(int newValue){
    latestValue = newValue;
    display();
   }

   public void display(){
     System.out.println("Latest Stock Price = " + latestValue);
   }

   public void unSubscribe(){
     stockMarket.unRegisterObserver(this);
   }
}
```
