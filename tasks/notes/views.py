from django.shortcuts import render_to_response, get_object_or_404
from django.template import RequestContext
from django.http import HttpResponseRedirect
from django.core.urlresolvers import reverse
from notes.models import Note



def index(request):
    """Show all notes that are old enough"""
    oldest_notes = Note.objects.filter(deleted=False).order_by('created')[:20]
    return render_to_response('notes/index.html',
                              {'oldest_notes': oldest_notes},
                              context_instance=RequestContext(request))



def details(request, note_id):
    """Show the detail of specified note"""
    note = get_object_or_404(Note, pk=note_id)
    return render_to_response('notes/details.html', {'note': note})


def add(request):
    note = Note(text=request.POST['text'], tags=request.POST['tags'])
    note.save()
    return HttpResponseRedirect(reverse('notes.views.index'))
