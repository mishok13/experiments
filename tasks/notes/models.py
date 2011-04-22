from django.db import models


class Note(models.Model):
    text = models.TextField('The text of the note')
    created = models.DateTimeField('Date created')
    deleted = models.BooleanField('Is the note deleted (done)', default=False)
    tags = models.TextField('Set of comma-separated tags')

    def __unicode__(self):
        return u'<Note object, text: %s, created at: %s>' % (self.text, self.created)
