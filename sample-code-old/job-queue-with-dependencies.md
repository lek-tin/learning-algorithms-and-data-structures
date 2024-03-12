
Requirements
- Implement a generic job queue system in Java with requirements below A job data structure:
	- ID field. A field to identify the job
	- run() method which does the work of the job. Can just print ID of the job
- A job queue data structure:
	- enqueue(Job j) method which takes a job as an argument and adds the job to the queue - addDepency(Job a, Job b), where a depends on b.
	- runJobs() method. Runs all the jobs in the queue in the order submitted, if a job has dependecies, run dependencies first. If there is a dependency cycle, throw an error
	- follow up: runJobsOptimistically() method, as same runJobs(), but ignore possible cycle, print all other possible jobs.

Solution:
Refer to [[topological-sort]], but you need to maintain a hashset of cyclic nodes so the order doesn't include them.