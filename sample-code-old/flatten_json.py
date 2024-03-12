# Used to flatten json object while using pandas
# reference: https://towardsdatascience.com/flattening-json-objects-in-python-f5343c794b10
from pandas.io.json import json_normalize

def flatten_json(y):
    out = {}
    # optimization
    timer = 0
    
    def __flatten(timer, x, name=''):
        if timer > 10000:
          return
        
        if type(x) is dict:
            for a in x:
                timer += 1
                __flatten(timer, x[a], name + a + '_')
        elif type(x) is list:
            i = 0
            for a in x:
                timer += 1
                __flatten(timer, a, name + str(i) + '_')
                i += 1
        else:
            out[name[:-1]] = x
            
    __flatten(0, y)
    return out
  
flat = flatten_json(sample_object)
json_normalize(flat)

