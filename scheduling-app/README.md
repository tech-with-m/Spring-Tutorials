# Spring Boot Scheduling Tutorial

This project demonstrates how to implement scheduled tasks in a Spring Boot application.

## Features

- Different scheduling methods (fixed rate, fixed delay, cron)
- Virtual thread configuration for optimal performance
- Thread pool configuration for scheduled tasks

## Project Structure

```
src/main/java/com/scheduler/SpringSchedulingTutorial/
├── SpringSchedulingTutorialApplication.java
├── config/
│   └── SchedulerConfig.java
└── task/
    └── ScheduledTasks.java
```

## Scheduling Methods

1. **Fixed Rate (`@Scheduled(fixedRate = 10000)`)**
   - Runs every 10 seconds
   - Executes at a fixed interval regardless of task completion

2. **Fixed Delay (`@Scheduled(fixedDelay = 15000, initialDelay = 5000)`)**
   - Runs 15 seconds after the previous execution completes
   - Waits 5 seconds before the first execution

3. **Cron Expression (`@Scheduled(cron = "0 0 * * * ?")`)**
   - Runs at the beginning of every hour

## Virtual Thread Configuration

The application configures virtual threads for scheduled tasks:

```java
@Override
public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    
    // Configure the scheduler to use virtual threads
    threadPoolTaskScheduler.setTaskExecutor(Executors.newVirtualThreadPerTaskExecutor());
    
    // Give virtual threads a meaningful name
    threadPoolTaskScheduler.setThreadNamePrefix("virtual-scheduled-task-");
    
    threadPoolTaskScheduler.initialize();
    
    taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
}
```

Virtual threads (available in Java 21+) provide several advantages:
- Significantly lower resource usage (KB vs MB per thread)
- More efficient handling of blocking operations
- Better throughput for I/O-bound tasks
- No need to manage thread pool sizes

## Running the Application

```
./mvnw spring-boot:run
```

## Testing

Run the tests with:

```
./mvnw test
