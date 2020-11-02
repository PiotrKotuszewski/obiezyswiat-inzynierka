package main.main.Service;

import main.main.Model.Subscription;
import main.main.Repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public void addSubscription(Subscription subscription){
        subscriptionRepository.save(subscription);
    }

    public void addSubscriptions(List<Subscription> subscriptionList){
        subscriptionList.forEach(subscriptionRepository::save);
    }
}
