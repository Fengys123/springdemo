package com.dlut.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.dlut")
@EnableScheduling
public class TaskSchedulerConfig
{
}
