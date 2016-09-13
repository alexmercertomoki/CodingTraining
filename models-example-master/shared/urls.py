from django.conf.urls import patterns, include, url

urlpatterns = patterns('',
    url(r'^$', 'shared.views.home'),
    url(r'^add-item', 'shared.views.add_item'),
    # Parses number from URL and uses it as the item_id argument to the action
    url(r'^delete-item/(?P<item_id>\d+)$', 'shared.views.delete_item'),
)
