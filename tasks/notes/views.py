from django.shortcuts import render_to_response, get_object_or_404
from notes.models import Note



def index(request):
    oldest_notes = Note.objects.filter(deleted=False).order_by('created')[:20]
    return render_to_response('notes/index.html',
                              {'oldest_notes': oldest_notes})


def details(request, note_id):
    note = get_object_or_404(Note, pk=note_id)
    return render_to_response('notes/details.html', {'note': note})
