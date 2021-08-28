# Disaggregated Storage

"Traditional" hyper-converged infrastructure:
- **Direct Attached Storage**: slow protocol, modest capacity requirement, near computed elements

**Requirements**
- Modern Workload - various types, and distribution workload type variety by time.
- Network Fabric - efficiency & latency, cross fabric interconnectivity rivals DAS
- Powerful Controller - process & access at max bandwidth and low latency, vending SSDs to the network without loss of bandwidth.
- Tons of IOPS so that you can connect many compute nodes to storage.

**Benefits**:
- Supports resource pooling to fit applications with large data sets.
- Enables on-demand infra - right sized, flexible and compose-able.
    - Upgrade components instead of entire system.
    - Cheaper than oversized solution (high capital expenditure)
    - Less complex than menu of options (high operation expenditure)
- Improve reliability & durability of storage servers as 
    - Stateless required: no need to move data, and no need to migrate workload.
    - Fault tolerant (storage pool - replications & erasure encoding)
    - Live deployment
