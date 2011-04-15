from django.db import models


class Note(models.Model):
    text = models.TextField()
    created = models.DateTimeField('Date created')
    tags = models.TextField()
