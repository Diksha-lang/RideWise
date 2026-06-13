# Object Relationships

# Rider -> Ride

Association

A rider can request multiple rides.

# Driver -> Ride

Association

A driver can complete multiple rides over time.

# Ride -> FareReceipt

Composition

FareReceipt is generated for a Ride.

# RideService -> Strategy Classes

Composition

RideService uses:

* RideMatchingStrategy
* FareStrategy

These strategies can be changed without changing RideService.
