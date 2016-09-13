from django.db import models

class Student(models.Model):
    andrew_id = models.CharField(max_length=8, primary_key=True)
    fname = models.CharField(max_length=8)
    lname = models.CharField(max_length=8)

    def __unicode__(self):
        return self.fname+" "+self.lname+" ("+self.andrew_id+")"

class Course(models.Model):
    name = models.CharField(max_length=200)
    number = models.CharField(max_length=6)
    students = models.ManyToManyField(Student)

    def __unicode__(self):
        return self.name
        
