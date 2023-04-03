package com.example.batchdemo.common.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class JobScheduler {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job ExampleJob;

    // @Scheduled(cron = "0/15 * * * * *")
    // public void jobSchduled() throws JobParametersInvalidException,
    // JobExecutionAlreadyRunningException,
    // JobRestartException, JobInstanceAlreadyCompleteException {

    // Map<String, JobParameter> jobParametersMap = new HashMap<>();

    // SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    // Date time = new Date();

    // String time1 = format1.format(time);

    // JobParameters parameters = new JobParameters(jobParametersMap);

    // JobExecution jobExecution = jobLauncher.run(ExampleJob, parameters);

    // // while (jobExecution.isRunning()) {
    // // log.info("...");
    // // }

    // log.info("Job Execution: " + jobExecution.getStatus());
    // log.info("Job getJobId: " + jobExecution.getJobId());
    // log.info("Job getExitStatus: " + jobExecution.getExitStatus());
    // log.info("Job getJobInstance: " + jobExecution.getJobInstance());
    // log.info("Job getStepExecutions: " + jobExecution.getStepExecutions());
    // log.info("Job getLastUpdated: " + jobExecution.getLastUpdated());
    // log.info("Job getFailureExceptions: " + jobExecution.getFailureExceptions());

    // }

    // @Scheduled(fixedDelay = 60 * 60 * 1000L)
    // @Scheduled(cron = "0/20 * * * * *")
    @Scheduled(initialDelay = 10000, fixedDelay = 30000)
    public void executeJob() {
        try {
            System.out.println("***************************");
            System.out.println("---batch TEST is Running---");
            System.out.println("***************************");
            // log.info("***************************");
            // log.info("---batch TEST is Running---");
            // log.info("***************************");

            Map<String, JobParameter> jobParametersMap = new HashMap<>();

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            Date time = new Date();

            String time1 = format1.format(time);

            JobParameters parameters = new JobParameters(jobParametersMap);

            jobLauncher.run(
                    ExampleJob,
                    parameters);
            System.out.println("***************************");
            System.out.println("-successfully complete job-");
            System.out.println("***************************");
        } catch (JobExecutionException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
