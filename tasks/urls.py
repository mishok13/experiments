from django.conf.urls.defaults import patterns, include, url

# Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns(
    '',
    url(r'index', 'notes.views.index'),
    url(r'^notes/add/$', 'notes.views.add'),
    url(r'^notes/(?P<note_id>\d+)/$', 'notes.views.details'),
    url(r'^admin/', include(admin.site.urls)),
    )
