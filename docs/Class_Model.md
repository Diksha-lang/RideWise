# Class Model

# Rider

Attributes:

* id
* name
* location

# Driver

Attributes:

* id
* name
* currentLocation
* available
* ridesCompleted

# Ride

Attributes:

* id
* rider
* driver
* distance
* status

# FareReceipt

Attributes:

* rideId
* amount
* generatedAt

# RideStatus

Values:

* REQUESTED
* ASSIGNED
* COMPLETED
* CANCELLED
