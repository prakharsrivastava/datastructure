class Bucket:
    """Represents a single bucket in extendible hashing."""
    def __init__(self, size, local_depth):
        self.size = size
        self.local_depth = local_depth
        self.keys = []

    def is_full(self):
        """Check if the bucket is full."""
        return len(self.keys) >= self.size

    def insert(self, key):
        """Insert a key into the bucket."""
        if not self.is_full():
            self.keys.append(key)
            return True
        return False

    def search(self, key):
        """Search for a key in the bucket."""
        return key in self.keys

    def split(self):
        """Splits a full bucket into two new buckets."""
        new_bucket = Bucket(self.size, self.local_depth + 1)
        old_keys = self.keys[:]
        self.keys.clear()
        return new_bucket, old_keys

class ExtendibleHashing:
    """Implements extendible hashing with dynamic bucket splitting."""
    def __init__(self, bucket_size):
        self.global_depth = 1
        self.bucket_size = bucket_size
        self.directory = [Bucket(bucket_size, self.global_depth) for _ in range(2)]

    def get_index(self, key):
        """Get index of the directory for a given key."""
        return key % (2 ** self.global_depth)

    def insert(self, key):
        """Insert a key and handle overflow if needed."""
        index = self.get_index(key)
        bucket = self.directory[index]

        if bucket.insert(key):
            print(f"Inserted {key} in bucket {index}.")
            return

        # If bucket is full, split it
        print(f"Bucket {index} full, splitting...")
        new_bucket, old_keys = bucket.split()
        bucket.local_depth += 1

        # If local depth exceeds global depth, expand directory
        if bucket.local_depth > self.global_depth:
            self.global_depth += 1
            self.directory += self.directory

        # Redistribute keys
        self.directory[index] = bucket
        new_index = index + (2 ** (bucket.local_depth - 1))
        self.directory[new_index] = new_bucket

        for k in old_keys + [key]:
            self.insert(k)

    def search(self, key):
        """Search for a key in the hash table."""
        index = self.get_index(key)
        bucket = self.directory[index]
        return bucket.search(key)

    def display(self):
        """Display the current hash structure."""
        print("\n--- Extendible Hashing Directory ---")
        for i, bucket in enumerate(self.directory):
            print(f"Index {i} (Depth {bucket.local_depth}): {bucket.keys}")

# Example Usage
hash_table = ExtendibleHashing(bucket_size=2)
keys_to_insert = [5, 12, 15, 8, 25, 30]

for key in keys_to_insert:
    hash_table.insert(key)

hash_table.display()

# Search for a key
key_to_search = 12
print(f"\nKey {key_to_search} found? {hash_table.search(key_to_search)}")
