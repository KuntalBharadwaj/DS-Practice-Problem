class BrowserHistory {

    List<String> pages = new ArrayList<>();
    int current;

    private String homepage;

    public BrowserHistory(String homepage) {
        pages.add(homepage);
        current = 0;
    }

    public void visit(String url) {
        while(current < pages.size()-1) {
            pages.remove(pages.size()-1);
        }

        pages.add(url);
        current++;
    }

    public String back(int steps) {
        if((current - steps) >= 0) {
            current -= steps;
            return pages.get(current);
        }
        else {
            current = 0;
            return pages.get(current);
        }
    }

    public String forward(int steps) {
        if((current + steps) < pages.size()) {
            current += steps;
            return pages.get(current);
        }
        else {
            current = pages.size()-1;
            return pages.get(current);
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */