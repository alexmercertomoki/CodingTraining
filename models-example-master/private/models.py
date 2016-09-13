from django.db import models

# User class for built-in authentication module
from django.contrib.auth.models import User

class Item(models.Model):
    text = models.CharField(max_length=200)
    date = models.CharField(max_length=50)
    user = models.ForeignKey(User)
    def __unicode__(self):
        return self.text+self.date
