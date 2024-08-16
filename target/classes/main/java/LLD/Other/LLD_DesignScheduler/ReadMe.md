# Design Job Scheduler
Ref: https://www.youtube.com/watch?v=l6uKzV7yZzM&ab_channel=TechDiscussion

## Requirement:
1. User should be able to schedule adhoc events
2. User should be able to schedule a recurring event with fixed rate
3. User should be able to schedule a recurring event with some delay rate

## NFR:
1. Async
2. Concurrent
3. Multithreading

## Proposed Solutions:

### Entities:
- Demo - Test cases and scenarios I want to run to
- ScheduleService - this where I will trigger all the APIs
- ScheduledJobPool - Can I delegate actual business logic here?
- Job or Task - What I want to actually run?
- TaskType {OneTime, FixedRate, FixedDelay}
- Queue - PriorityQueue - push the task/job and then, will poll from top of it.

### Design Pattern:
- Singleton - SchedulerService

### Data Structures:
- PQ
- Deadlock?

### Concurrency
1. ExecutorService
2. ThreadPool

Questions:
1. Deadlocks?