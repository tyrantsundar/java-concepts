

Q1 : Can you explain the Singleton Design Pattern? 
     Could you also implement it in a thread-safe way in Java?

    🔹 Definition:
        The Singleton Pattern ensures that only one instance of a class is created and 
        provides a global point of access to it.
    🔹 Use Cases:
            1. Logging 
            2. Configuration settings 
            3. Database connection pooling 
            4. Caching
            5. Thread pools

Q2 : How will you break a Singleton using Reflection or Serialization?
    
    🔨 Reflection:
        You can use Java Reflection to access the private constructor and create another instance.
    Check byPassSingleTonByReflection() in Test class.


Q3 : How do you prevent breaking Singleton using Enum?

    ✅ Enum Singletons are inherently safe:
        1. Enums handle Serialization & Reflection internally.
        2. JVM ensures only one instance even in multithreaded or deserialized scenarios.

Q4 : How does Singleton differ from static class/methods?

        Feature                 |           Singleton               |        Static Class/Method
        Instance-based          |   Has a single object             |       No instance, only class-level
        Extensible              |    Yes (can implement interfaces) |       No (cannot implement/extend)
        Lazy Initialization     |   Yes (via getInstance())         |       No (loaded on class load)
        OOP Friendly            |               Yes                 |       Less flexible
        Testing/Mocking         |           Easier to mock          |       Difficult to test/mock

✅ Use Singleton when object behavior/state is needed.
🛑 Avoid static when flexibility and testability matter.


Q5 : Is Singleton good for multithreaded environments?
    
    ✅ It can be, only if implemented properly:
        Use double-checked locking + volatile variable.
        Or use Bill Pugh Singleton (static inner class). 
        Or use Enum (best for safety).

Q6 : How would you implement Singleton in a distributed system (e.g., Microservices)?
   
    🚫 Normal Singleton won't work across JVMs or containers.
    ✅ Alternatives for Distributed Singleton:
    i)   Shared Cache (Redis/Memcached): Store shared object/config/status.
    ii)  Service Registry (like Eureka): Only one instance of a service is registered as "leader".
    iii) Leader Election using:
       1. Zookeeper
       2. Consul
       3. etcd
    iv)  Database Row Locking (rare): Ensure only one row represents the active instance.
    🧠 Example use case: Only one scheduler/microservice runs a job at a time.

