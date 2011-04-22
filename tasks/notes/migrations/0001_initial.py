# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding model 'Note'
        db.create_table('notes_note', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.TextField')()),
            ('created', self.gf('django.db.models.fields.DateTimeField')()),
            ('deleted', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('tags', self.gf('django.db.models.fields.TextField')()),
        ))
        db.send_create_signal('notes', ['Note'])


    def backwards(self, orm):
        
        # Deleting model 'Note'
        db.delete_table('notes_note')


    models = {
        'notes.note': {
            'Meta': {'object_name': 'Note'},
            'created': ('django.db.models.fields.DateTimeField', [], {}),
            'deleted': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'tags': ('django.db.models.fields.TextField', [], {}),
            'text': ('django.db.models.fields.TextField', [], {})
        }
    }

    complete_apps = ['notes']
