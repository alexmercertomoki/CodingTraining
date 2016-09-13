from django.shortcuts import render
from threading import Lock

shared_list = []
lock = Lock()

def home(request):
    # make a copy of the list (others may be changing concurrently with this request)
    with lock:
        my_copy = list(shared_list)
        
    context = {'items':my_copy}
    return render(request, 'shared/index.html', context)

def add_item(request):
    errors = []  # A list to record messages for any errors we encounter.

    # Adds the new item to the list if the request parameter is present
    if not 'item' in request.POST or not request.POST['item']:
        errors.append('You must enter an item to add.')
    else:
        item = request.POST['item']
        print 'Adding item'
        print '    IP Addr = ', request.META['REMOTE_ADDR']
        print '    item = ', item
        with lock:
            shared_list.append(item)

    # Sets up data needed to generate the view, and generates the view
    with lock:
        my_copy = list(shared_list)
    context = {'items':my_copy, 'errors':errors}
    return render(request, 'shared/index.html', context)
    
# Action for the shared-todo-list/delete-item route.
def delete_item(request):
    errors = []

    if not 'item' in request.GET:
        errors.append('Missing parameter: item')
    else:
        item = request.GET['item']
        with lock:
            try:
                shared_list.remove(item)
            except ValueError:
                errors.append('This item is not on the list: ' + item)

    # Sets up data needed to generate the view, and generates the view
    with lock:
        my_copy = list(shared_list)
    context = {'items':my_copy, 'errors':errors}
    return render(request, 'shared/index.html', context)
