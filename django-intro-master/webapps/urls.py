from django.conf.urls import patterns, include, url
from django.contrib import admin

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'webapps.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    url(r'^admin/', include(admin.site.urls)),

    url(r'^$', 'intro.views.home_page'),
    url(r'^hello-world$', 'intro.views.hello_world'),
    url(r'^hello-world-with-template$', 'intro.views.hello_world_with_template'),
    url(r'^greet$', 'intro.views.greet'),
)
