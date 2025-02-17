
def sortInWavess(arr,n):
        for i in range(0,n,2):
            if(i>0 and arr[i]<arr[i-1]):
                arr[i],arr[i-1]=arr[i-1],arr[i]
                
            if(i<n-1 and arr[i]<arr[i+1]):
                arr[i],arr[i+1]=arr[i+1],arr[i]    
         
       


arr = [10, 90, 49, 2, 1, 5, 23]  
sortInWavess(arr,len(arr))

for x in range(0,len(arr)):
        print(arr[x])  





