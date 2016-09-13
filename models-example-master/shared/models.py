from django.db import models


# Data model for a todo-list item
class Item(models.Model):
    text = models.CharField(max_length=200)
    ip_addr = models.GenericIPAddressField()

    def __unicode__(self):
        return 'id=' + str(self.id) + ',text="' + self.text + '"'
