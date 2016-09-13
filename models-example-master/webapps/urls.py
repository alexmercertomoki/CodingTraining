from django.conf.urls import patterns, include, url

urlpatterns = patterns('',
    url(r'^private/', include('private.urls')),
    url(r'^shared/',  include('shared.urls')),
)
