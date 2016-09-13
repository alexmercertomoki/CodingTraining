from django.shortcuts import render
from django.core.exceptions import ObjectDoesNotExist

# Imports the Item class
from shared.models import *


# Action for the default shared-todo-list/ route.
def home(request):
    # Gets a list of all the items in the todo-list database.
    all_items = Item.objects.all()

    # render takes: (1) the request,
    #               (2) the name of the view to generate, and
    #               (3) a dictionary of name-value pairs of data to be
    #                   available to the view.
    return render(request, 'shared/index.html', {'items': all_items})


# Action for the shared-todo-list/add-item route.
def add_item(request):
    errors = []  # A list to record messages for any errors we encounter.

    # Adds the new item to the database if the request parameter is present
    if 'item' not in request.POST or not request.POST['item']:
        errors.append('You must enter an item to add.')
    else:
        new_item = Item(text=request.POST['item'], ip_addr=request.META['REMOTE_ADDR'])
        new_item.save()

    # Sets up data needed to generate the view, and generates the view
    items = Item.objects.all()
    context = {'items': items, 'errors': errors}
    return render(request, 'shared/index.html', context)


# Action for the shared-todo-list/delete-item route.
def delete_item(request, item_id):
    errors = []

    # Deletes the item if present in the todo-list database.
    try:
        item_to_delete = Item.objects.get(id=item_id)
        item_to_delete.delete()
    except ObjectDoesNotExist:
        errors.append('The item did not exist in the todo list.')

    items = Item.objects.all()
    context = {'items': items, 'errors': errors}
    return render(request, 'shared/index.html', context)
