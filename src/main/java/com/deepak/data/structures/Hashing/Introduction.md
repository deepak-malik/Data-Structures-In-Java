### Hashing Introduction

#### What is Hashing?
- Algorithm that calculates a fixed-size bit value of a given resource(block of data). 
- Hashing transforms this data into a far shorter fixed-length value or key. 
- The hash value can be considered the distilled summary of everything within that file.
- A good hashing algorithm would exhibit a property called the avalanche effect, where the resulting hash output would change significantly or entirely even when a single bit or byte of data within a file is changed. 
- A hash function that does not do this is considered to have poor randomization, which would be easy to break by hackers.
- A hash is usually a hexadecimal string of several characters. 
- Hashing is also a unidirectional process so you can never work backwards to get back the original data.
- A good hash algorithm should be complex enough such that it does not produce the same hash value from two different inputs. 
- If it does, this is known as a hash collision. 
- A hash algorithm can only be considered good and acceptable if it can offer a very low chance of collision.

#### Why do we need it?
- If you are transferring a file from one computer to another, how do you ensure that the copied file is the same as the source? 
- One method you could use is called hashing, which is essentially a process that translates information about the file into a code. 
- Two hash values (of the original file and its copy) can be compared to ensure the files are equal.

#### Benefits of Hashing?
- One main use of hashing is to compare two files for equality. 
- Without opening two document files to compare them word-for-word, the calculated hash values of these files will allow the owner to know immediately if they are different.
- Hashing is also used to verify the integrity of a file after it has been transferred from one place to another, typically in a file backup program like SyncBack. 
- To ensure the transferred file is not corrupted, a user can compare the hash value of both files. If they are the same, then the transferred file is an identical copy.
- In some situations, an encrypted file may be designed to never change the file size nor the last modification date and time (for example, virtual drive container files). 
- In such cases, it would be impossible to tell at a glance if two similar files are different or not, but the hash values would easily tell these files apart if they are different.
- Ex. Verifying checksum of a deployed war or jar file on server

#### Types of Hashing
There are many different types of hash algorithms such as RipeMD, Tiger, xxhash and more, but the most common type of hashing used for file integrity checks are MD5, SHA1 and CRC32.
- **MD5** - An MD5 hash function encodes a string of information and encodes it into a 128-bit fingerprint. MD5 is often used as a checksum to verify data integrity. However, due to its age, MD5 is also known to suffer from extensive hash collision vulnerabilities, but it’s still one of the most widely used algorithms in the world.
- **SHA1** – SHA1, developed by the National Security Agency (NSA), is a cryptographic hash function. Results from SHA1 are expressed as a 160-bit hexadecimal number. This hash function is widely considered the successor to MD5.
- **CRC32** – A cyclic redundancy check (CRC) is an error-detecting code often used for detection of accidental changes to data. Encoding the same data string using CRC32 will always result in the same hash output, thus CRC32 is sometimes used as a hash algorithm for file integrity checks.
