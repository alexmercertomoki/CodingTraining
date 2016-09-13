from django.conf.urls import patterns, include, url
from django.contrib import admin

urlpatterns = patterns('',
    # Examples:
    # url(r'^blog/', include('blog.urls')),

    # url(r'^admin/', include(admin.site.urls)),

    url(r'^$',        'welcome.views.home'),
    url(r'^hidden/',  'hidden.views.hidden_demo'),
    url(r'^shared/',  include('shared.urls')),
    url(r'^private/', include('private.urls')),
)
