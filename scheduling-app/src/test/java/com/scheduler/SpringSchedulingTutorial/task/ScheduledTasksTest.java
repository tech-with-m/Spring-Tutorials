package com.scheduler.SpringSchedulingTutorial.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ScheduledTasksTest {

    @InjectMocks
    private ScheduledTasks scheduledTasks;

    @Test
    void testFixedRateTaskSchedulingConfiguration() throws NoSuchMethodException {
        Method method = ScheduledTasks.class.getMethod("executeFixedRateTask");
        Scheduled annotation = method.getAnnotation(Scheduled.class);
        assertNotNull(annotation);
        assertEquals(10000, annotation.fixedRate());
    }

    @Test
    void testFixedDelayTaskSchedulingConfiguration() throws NoSuchMethodException {
        Method method = ScheduledTasks.class.getMethod("executeFixedDelayTask");
        Scheduled annotation = method.getAnnotation(Scheduled.class);
        assertNotNull(annotation);
        assertEquals(15000, annotation.fixedDelay());
        assertEquals(5000, annotation.initialDelay());
    }

    @Test
    void testCronTaskSchedulingConfiguration() throws NoSuchMethodException {
        Method method = ScheduledTasks.class.getMethod("executeCronTask");
        Scheduled annotation = method.getAnnotation(Scheduled.class);
        assertNotNull(annotation);
        assertEquals("0 0 * * * ?", annotation.cron());
    }
}
